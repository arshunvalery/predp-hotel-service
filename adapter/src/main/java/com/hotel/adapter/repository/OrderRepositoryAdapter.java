package com.hotel.adapter.repository;

import com.hotel.application.api.repository.OrderRepository;
import com.hotel.domain.Guest;
import com.hotel.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final GuestJpaRepository guestJpaRepository;

    @Override
    public Order save(Order order) {

        int facilitiesPrice = 0;

        for(int i = 0; i < order.getFacilities().size(); i++) {
            facilitiesPrice += order.getFacilities().get(i).getPrice();
        }

        Guest guest = new Guest();
        guest.setId(order.getGuest().getId());
        guest.setName(order.getGuest().getName());
        guest.setSurname(order.getGuest().getSurname());
        guest.setTel(order.getGuest().getTel());
        guest.setAge(order.getGuest().getAge());
        guest.setGender(order.getGuest().getGender());
        guest.setCash(order.getGuest().getCash() - (order.getRoom().getPrice() + facilitiesPrice));
        guestJpaRepository.save(guest);

        return orderJpaRepository.save(order);
    }

    @Override
    public Collection<Order> findAll() {
        return orderJpaRepository.findAll();
    }

    @Override
    public Optional<Order> findById(UUID id) {
        return orderJpaRepository.findById(id);
    }

    @Override
    public UUID delete(UUID id) {
        orderJpaRepository.deleteById(id);
        return id;
    }

    @Override
    public Order update(Order order) {

        int facilitiesPrice = 0;

        for(int i = 0; i < order.getFacilities().size(); i++) {
            facilitiesPrice += order.getFacilities().get(i).getPrice();
        }

        Guest guest = new Guest();
        guest.setId(order.getGuest().getId());
        guest.setName(order.getGuest().getName());
        guest.setSurname(order.getGuest().getSurname());
        guest.setTel(order.getGuest().getTel());
        guest.setAge(order.getGuest().getAge());
        guest.setGender(order.getGuest().getGender());
        guest.setCash(order.getGuest().getCash() - order.getRoom().getPrice() + facilitiesPrice);
        guestJpaRepository.save(guest);

        return orderJpaRepository.save(order);
    }
}
