package com.hotel.adapter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GuestDto {
    private UUID id;
    @Size(max = 20)
    @Pattern(regexp = "^([А-Я][а-я]*|[A-Z][a-z]*)")
    private String name;
    @Size(max = 20)
    @Pattern(regexp = "^([А-Я][а-я]*|[A-Z][a-z]*)")
    private String surname;
    @Size(max = 7)
    @Pattern(regexp = "[0-9]+")
    private String tel;
    @NotNull
    @Min(5)
    @Max(100)
    private Integer age;
    @NotNull
    private String gender;
    @Max(1000)
    private Integer cash;
}
