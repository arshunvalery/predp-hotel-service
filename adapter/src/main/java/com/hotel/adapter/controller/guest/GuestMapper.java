package com.hotel.adapter.controller.guest;

import com.hotel.adapter.controller.BaseMapper;
import com.hotel.domain.Guest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GuestMapper extends BaseMapper<GuestDto, Guest> {
}
