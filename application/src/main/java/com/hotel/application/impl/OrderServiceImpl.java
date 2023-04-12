package com.hotel.application.impl;

import com.hotel.application.api.integration.MicroHotelService;
import com.hotel.application.api.repository.OrderRepository;
import com.hotel.application.api.repository.RoomRepository;
import com.hotel.application.api.service.OrderService;
import com.hotel.application.exceptions.ResourceCantBePurchasedException;
import com.hotel.application.exceptions.ResourceIsUsedException;
import com.hotel.application.exceptions.ResourceNotFoundException;
import com.hotel.application.exceptions.ResourceWithUncorrectDate;
import com.hotel.domain.Order;
import com.hotel.domain.Room;
import com.hotel.domain.enums.RoomStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final RoomRepository roomRepository;
    private final OrderRepository orderRepository;
    private final MicroHotelService microHotelService;

    @Transactional
    @Override
    public Order create(Order entity) {
        log.info("Я - МЕТОД СОЗДАНИЯ В СЕРВИСЕ ЗАКАЗА!!!");

        if(!microHotelService.isPurchasePossible(entity))
        {
            throw new ResourceCantBePurchasedException("гостя", "cash");
        }

        if (!entity.getDateSettlement().isAfter(LocalDate.now())
                || !entity.getDateSettlement().isBefore(LocalDate.now().plusYears(1))
                || !entity.getDateFree().isAfter(entity.getDateSettlement())
                || !entity.getDateFree().isBefore(LocalDate.now().plusYears(1))) {
            throw new ResourceWithUncorrectDate("Заказ", "датой");
        }

        Room room = roomRepository.findById(entity.getRoom().getId()).
                orElseThrow(() -> new ResourceNotFoundException("Room", "ID", entity.getRoom().getId()));

        if(room.getStatus().toString().equals("BUSY") || room.getStatus().toString().equals("REPAIRED")){
            throw new ResourceIsUsedException("Комната", "номером", room.getNumber());
        }

        roomRepository.autoChangeStatus(room, RoomStatus.BUSY);
        entity.setRoom(room);

        return orderRepository.save(entity);
    }

    @Transactional
    @Override
    public Collection<Order> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В СЕРВИСЕ ЗАКАЗА!!!");
        return orderRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Order findById(UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В СЕРВИСЕ ЗАКАЗА!!!");
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "ID", id));
    }

    @Transactional
    @Override
    public UUID delete(UUID id) {
        log.info("Я - МЕТОД УДАЛЕНИЯ ОДНОГО В СЕРВИСЕ ЗАКАЗА!!!");
        Order entity = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order", "ID", id));
        roomRepository.autoChangeStatus(entity.getRoom(), RoomStatus.FREE);
        return orderRepository.delete(id);
    }

    @Transactional
    @Override
    public Order update(Order entity) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ ОДНОГО В СЕРВИСЕ ЗАКАЗА!!!");

        if(!microHotelService.isPurchasePossible(entity))
        {
            throw new ResourceCantBePurchasedException("гостя", "cash");
        }

        if (!entity.getDateSettlement().isAfter(LocalDate.now())
                || !entity.getDateSettlement().isBefore(LocalDate.now().plusYears(1))
                || !entity.getDateFree().isAfter(entity.getDateSettlement())
                || !entity.getDateFree().isBefore(LocalDate.now().plusYears(1))) {
            throw new ResourceWithUncorrectDate("Заказ", "датой");
        }

        Room room = roomRepository.findById(entity.getRoom().getId()).
                orElseThrow(() -> new ResourceNotFoundException("Room", "ID", entity.getRoom().getId()));

        if(room.getStatus().toString().equals("BUSY") || room.getStatus().toString().equals("REPAIRED")){
            throw new ResourceIsUsedException("Комната", "номером", room.getNumber());
        }

        roomRepository.autoChangeStatus(room, RoomStatus.BUSY);
        entity.setRoom(room);

        return orderRepository.update(entity);
    }
}
