package com.hotel.adapter.repository;

import com.hotel.domain.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FacilityJpaRepository extends JpaRepository<Facility, UUID> {
}
