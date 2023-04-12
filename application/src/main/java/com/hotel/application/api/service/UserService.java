package com.hotel.application.api.service;

import com.hotel.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.UUID;

public interface UserService extends UserDetailsService {

    User create(User entity);

    Collection<User> findAll();

    User findById(UUID id);

    UUID delete(UUID id);

    User update(User entity);

    UserDetails loadUserByUsername(String str);
}