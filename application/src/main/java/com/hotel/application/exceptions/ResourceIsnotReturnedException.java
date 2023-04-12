package com.hotel.application.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
@Data
public class ResourceIsnotReturnedException extends RuntimeException{
    private String resourceName;

    public ResourceIsnotReturnedException(String resourceName) {
        super(String.format("Объект %s не вернулся с микросервиса", resourceName));
        this.resourceName = resourceName;
    }
}
