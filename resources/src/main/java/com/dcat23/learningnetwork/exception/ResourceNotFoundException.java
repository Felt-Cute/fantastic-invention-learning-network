package com.dcat23.learningnetwork.exception;

import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResourceNotFoundException extends EntityNotFoundException {

    private final HttpStatus statusCode = HttpStatus.NOT_FOUND;

    public ResourceNotFoundException(Long resourceId) {
        super(String.format("Resource with id '%d' not found", resourceId));
    }

}
