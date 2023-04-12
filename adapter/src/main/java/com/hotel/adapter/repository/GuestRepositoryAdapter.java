package com.hotel.adapter.repository;

import com.hotel.application.api.repository.GuestRepository;
import com.hotel.domain.Guest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GuestRepositoryAdapter implements GuestRepository {

    private final GuestJpaRepository guestJpaRepository;

    @Override
    public Guest save(Guest entity) {
        return guestJpaRepository.save(entity);
    }

    @Override
    public Collection<Guest> findAll() {
        return guestJpaRepository.findAll();
    }

    @Override
    public Optional<Guest> findById(UUID id) {
        return guestJpaRepository.findById(id);
    }

    @Override
    public UUID delete(UUID id) {
        guestJpaRepository.deleteById(id);
        return id;
    }

    @Override
    public Guest update(Guest entity) {
        return guestJpaRepository.save(entity);
    }
}
