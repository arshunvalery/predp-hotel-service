package com.hotel.application.api.service;

import com.hotel.domain.Guest;

import java.util.Collection;
import java.util.UUID;

public interface GuestService {

    Guest create(Guest entity);

    Collection<Guest> findAll();

    Guest findById(UUID id);

    UUID delete(UUID id);

    Guest update(Guest entity);
}
