package com.hotel.application.impl;

import com.hotel.application.api.repository.UserRepository;
import com.hotel.application.api.service.UserService;
import com.hotel.application.exceptions.ResourceNotFoundException;
import com.hotel.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public User create(User entity) {
        log.info("Я - МЕТОД СОЗДАНИЯ В СЕРВИСЕ ГОСТЯ!!!");
        return userRepository.save(entity);
    }

    @Transactional
    @Override
    public Collection<User> findAll() {
        log.info("Я - МЕТОД ВЫВОДА ВСЕГО В СЕРВИСЕ ГОСТЯ!!!");
        return userRepository.findAll()
                .stream()
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public User findById(UUID id) {
        log.info("Я - МЕТОД ВЫВОДА ОДНОГО В СЕРВИСЕ ГОСТЯ!!!");
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "ID", id));
    }

    @Transactional
    @Override
    public UUID delete(UUID id) {
        log.info("Я - МЕТОД УДАЛЕНИЯ ОДНОГО В СЕРВИСЕ ГОСТЯ!!!");
        return userRepository.delete(id);
    }

    @Transactional
    @Override
    public User update(User entity) {
        log.info("Я - МЕТОД ИЗМЕНЕНИЯ ОДНОГО В СЕРВИСЕ ГОСТЯ!!!");
        return userRepository.update(entity);
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("Я - МЕТОД АКТИВАЦИИ АДМИНА В СЕРВИСЕ ЮЗЕРА!!!");
        User user = userRepository.loadUserByUsername(userName);
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(user.getStatus().getRole()))
        );
    }
}
