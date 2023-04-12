package com.hotel.application.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
@Data
public class ResourceCantBePurchasedException extends RuntimeException{
    private String resourceName;
    private String fieldName;

    public ResourceCantBePurchasedException(String resourceName, String fieldName) {
        super(String.format("У %s не хватает значений в поле %s", resourceName, fieldName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
    }
}
