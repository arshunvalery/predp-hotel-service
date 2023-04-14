package com.hotel.adapter.controller.room;

import com.hotel.adapter.controller.BaseMapper;
import com.hotel.domain.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper extends BaseMapper<RoomDto, Room> {
}
