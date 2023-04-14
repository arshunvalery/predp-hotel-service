package com.hotel.adapter.controller.guest;

import com.hotel.application.api.service.GuestService;
import com.hotel.domain.Guest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GuestFacade {

    private final GuestService guestService;

    private final GuestMapper guestMapper;


    public GuestDto create(GuestDto guestDto) {
        Guest guest = guestMapper.toEntity(guestDto);
        return guestMapper.toDto(guestService.create(guest));
    }

    public Collection<GuestDto> findAll() {
        return guestService.findAll()
                .stream()
                .map(guestMapper::toDto)
                .collect(Collectors.toList());
    }

    public GuestDto findById(UUID id) {
        return guestMapper.toDto(guestService.findById(id));
    }

    public UUID delete(UUID id) {
        return guestService.delete(id);
    }

    public GuestDto update(GuestDto guestDto) {
        Guest guest = guestMapper.toEntity(guestDto);
        return guestMapper.toDto(guestService.update(guest));
    }
}
