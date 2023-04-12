package com.hotel.adapter.repository;

import com.hotel.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<User, UUID> {

    User findByUsername(String username);
}
