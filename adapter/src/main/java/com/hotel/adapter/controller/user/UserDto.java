package com.hotel.adapter.controller.user;

import com.hotel.domain.enums.UserStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    @NotNull
    @Size(max = 20)
    private String username;
    @NotNull
    private UserStatus status;
    @NotNull
    @Size(max = 10)
    private String password;
}
