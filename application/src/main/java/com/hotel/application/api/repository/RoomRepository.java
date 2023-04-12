package com.hotel.application.api.repository;

import com.hotel.domain.Room;
import com.hotel.domain.enums.RoomStatus;

public interface RoomRepository extends BaseRepository<Room>{

    RoomStatus changeStatus(Room room);

    Room autoChangeStatus(Room room, RoomStatus roomStatus);

    Boolean existsByRoomNumber(String number);
}
