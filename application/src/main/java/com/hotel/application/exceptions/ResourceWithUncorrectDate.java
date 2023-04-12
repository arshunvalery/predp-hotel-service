package com.hotel.application.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@Data
public class ResourceWithUncorrectDate extends RuntimeException{
    private String resourceName;
    private String fieldName;

    public ResourceWithUncorrectDate(String resourceName, String fieldName) {
        super(String.format("%s с этой %s введён некорректно (введите от текущего дня + 1 день до текущего дня + 1 год в формате год-месяц-день)", resourceName, fieldName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
    }
}
