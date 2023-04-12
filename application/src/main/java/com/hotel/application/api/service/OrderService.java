package com.hotel.application.api.service;

import com.hotel.domain.Order;

import java.util.Collection;
import java.util.UUID;

public interface OrderService {
    Order create(Order entity);

    Collection<Order> findAll();

    Order findById(UUID id);

    UUID delete(UUID id);

    Order update(Order entity);
}
