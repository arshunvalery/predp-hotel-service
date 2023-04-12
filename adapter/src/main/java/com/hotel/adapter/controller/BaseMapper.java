package com.hotel.adapter.controller;

import com.hotel.domain.BaseEntity;

public interface BaseMapper<DTO, ENTITY extends BaseEntity> {

    ENTITY toEntity(DTO dto);
    DTO toDto(ENTITY entity);
}
