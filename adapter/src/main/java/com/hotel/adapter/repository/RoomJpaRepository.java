package com.hotel.adapter.repository;

import com.hotel.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomJpaRepository extends JpaRepository<Room, UUID> {
}
