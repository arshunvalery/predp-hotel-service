package com.hotel.adapter.controller.user;

import com.hotel.application.api.service.UserService;
import com.hotel.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;

    private final UserMapper userMapper;


    public UserDto create(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userService.create(user));
    }

    public Collection<UserDto> findAll() {
        return userService.findAll()
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDto findById(UUID id) {
        return userMapper.toDto(userService.findById(id));
    }

    public UUID delete(UUID id) {
        return userService.delete(id);
    }

    public UserDto update(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        return userMapper.toDto(userService.update(user));
    }
}
