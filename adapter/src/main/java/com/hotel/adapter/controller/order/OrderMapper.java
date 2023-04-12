package com.hotel.adapter.controller.order;

import com.hotel.adapter.controller.BaseMapper;
import com.hotel.adapter.dto.OrderDto;
import com.hotel.domain.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends BaseMapper<OrderDto, Order> {
}

