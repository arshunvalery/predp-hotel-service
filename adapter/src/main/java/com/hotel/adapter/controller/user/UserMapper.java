package com.hotel.adapter.controller.user;

import com.hotel.adapter.controller.BaseMapper;
import com.hotel.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserDto, User> {
}
