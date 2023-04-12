package com.hotel.adapter.repository;

import com.hotel.application.api.repository.FacilityRepository;
import com.hotel.domain.Facility;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class FacilityRepositoryAdapter implements FacilityRepository {

    private final FacilityJpaRepository facilityJpaRepository;

    @Override
    public Facility save(Facility entity) {
        return facilityJpaRepository.save(entity);
    }

    @Override
    public Collection<Facility> findAll() {
        return facilityJpaRepository.findAll();
    }

    @Override
    public Optional<Facility> findById(UUID id) {
        return facilityJpaRepository.findById(id);
    }

    @Override
    public UUID delete(UUID id) {
        facilityJpaRepository.deleteById(id);
        return id;
    }

    @Override
    public Facility update(Facility entity) {
        return facilityJpaRepository.save(entity);
    }
}
