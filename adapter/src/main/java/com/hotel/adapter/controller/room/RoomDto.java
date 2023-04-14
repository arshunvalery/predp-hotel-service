package com.hotel.adapter.controller.room;

import com.hotel.domain.enums.RoomStatus;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.UUID;

@Data
public class RoomDto {
    private UUID id;
    @Size(max = 4)
    @Pattern(regexp = "^[1-9][0-9]*")
    private String number;
    private RoomStatus status;
    @NotNull
    @Min(0)
    @Max(1000)
    private int price;
}
