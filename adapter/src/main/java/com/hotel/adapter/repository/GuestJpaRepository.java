package com.hotel.adapter.repository;

import com.hotel.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GuestJpaRepository extends JpaRepository<Guest, UUID> {
}
