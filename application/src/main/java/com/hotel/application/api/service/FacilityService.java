package com.hotel.application.api.service;

import com.hotel.domain.Facility;

import java.util.Collection;
import java.util.UUID;

public interface FacilityService {

    Facility create(Facility entity);

    Collection<Facility> findAll();

    Facility findById(UUID id);

    UUID delete(UUID id);

    Facility update(Facility entity);
}
