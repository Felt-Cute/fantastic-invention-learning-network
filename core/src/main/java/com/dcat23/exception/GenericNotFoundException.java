package com.dcat23.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericNotFoundException extends RuntimeException {

    private final HttpStatus statusCode = HttpStatus.NOT_FOUND;

    public GenericNotFoundException(Long id) {
        super(String.format("Id '%d' not found", id));
    }

}
