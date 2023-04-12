package com.hotel.adapter.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.util.UUID;

@Data
public class FacilityDto {
    private UUID id;
    @NotNull
    @Pattern(regexp = "^([А-Я][а-я]*|[A-Z][a-z]*)")
    @Size(max = 10)
    private String title;
    @NotNull
    @Min(0)
    @Max(1000)
    private int price;
}
