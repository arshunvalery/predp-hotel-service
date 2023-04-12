package com.hotel.adapter.controller.room;

import com.hotel.adapter.dto.RoomDto;
import com.hotel.application.api.service.RoomService;
import com.hotel.domain.Room;
import com.hotel.domain.enums.RoomStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoomFacade {

    private final RoomService roomService;

    private final RoomMapper roomMapper;


    public RoomDto create(RoomDto guestDto) {
        Room guest = roomMapper.toEntity(guestDto);
        return roomMapper.toDto(roomService.create(guest));
    }

    public Collection<RoomDto> findAll() {
        return roomService.findAll()
                .stream()
                .map(roomMapper::toDto)
                .collect(Collectors.toList());
    }

    public RoomDto findById(UUID id) {
        return roomMapper.toDto(roomService.findById(id));
    }

    public UUID delete(UUID id) {
        return roomService.delete(id);
    }

    public RoomDto update(RoomDto roomDto) {
        Room guest = roomMapper.toEntity(roomDto);
        return roomMapper.toDto(roomService.update(guest));
    }

    public RoomStatus changeStatus(UUID id) {
        return roomService.changeStatus(id);
    }
}
