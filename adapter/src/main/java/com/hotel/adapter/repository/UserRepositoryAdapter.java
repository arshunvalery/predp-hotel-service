package com.hotel.adapter.repository;

import com.hotel.application.api.repository.UserRepository;
import com.hotel.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User save(User entity) {
        return userJpaRepository.save(entity);
    }

    @Override
    public Collection<User> findAll() {
        return userJpaRepository.findAll();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userJpaRepository.findById(id);
    }

    @Override
    public UUID delete(UUID id) {
        userJpaRepository.deleteById(id);
        return id;
    }

    @Override
    public User update(User entity) {
        return userJpaRepository.save(entity);
    }

    public User loadUserByUsername(String username) {
        return userJpaRepository.findByUsername(username);
    }
}
