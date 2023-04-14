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

    @Override
    public Order save(Order order) {
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
        return orderJpaRepository.save(order);
    }
}
