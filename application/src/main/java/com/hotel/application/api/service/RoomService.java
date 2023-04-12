package com.hotel.application.api.service;

import com.hotel.domain.Room;
import com.hotel.domain.enums.RoomStatus;

import java.util.Collection;
import java.util.UUID;

public interface RoomService {

    Room create(Room entity);

    Collection<Room> findAll();

    Room findById(UUID id);

    UUID delete(UUID id);

    Room update(Room entity);

    RoomStatus changeStatus(UUID id);
}