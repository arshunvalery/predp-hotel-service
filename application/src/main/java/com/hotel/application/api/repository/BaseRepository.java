package com.hotel.application.api.repository;

import com.hotel.domain.BaseEntity;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface BaseRepository<ENTITY extends BaseEntity> {

    ENTITY save(ENTITY entity);

    Collection<ENTITY> findAll();

    Optional<ENTITY> findById(UUID id);

    UUID delete(UUID id);

    ENTITY update(ENTITY entity);
}
