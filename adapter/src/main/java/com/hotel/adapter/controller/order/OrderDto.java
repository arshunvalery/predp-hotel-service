package com.hotel.adapter.controller.order;

import com.hotel.adapter.controller.facility.FacilityDto;
import com.hotel.adapter.controller.guest.GuestDto;
import com.hotel.adapter.controller.room.RoomDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class OrderDto {
    private UUID id;
    @NotNull
    private LocalDate dateSettlement;
    @NotNull
    private LocalDate dateFree;
    @NotNull
    private GuestDto guest;
    @NotNull
    private RoomDto room;
    @NotNull
    private List<FacilityDto> facilities;
}