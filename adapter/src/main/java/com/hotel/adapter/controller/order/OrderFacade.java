package com.hotel.adapter.controller.order;

import com.hotel.application.api.service.OrderService;
import com.hotel.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderService orderService;

    private final OrderMapper orderMapper;


    public OrderDto create(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        return orderMapper.toDto(orderService.create(order));
    }

    public Collection<OrderDto> findAll() {
        return orderService.findAll()
                .stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    public OrderDto findById(UUID id) {
        return orderMapper.toDto(orderService.findById(id));
    }

    public UUID delete(UUID id) {
        return orderService.delete(id);
    }

    public OrderDto update(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        return orderMapper.toDto(orderService.update(order));
    }
}
