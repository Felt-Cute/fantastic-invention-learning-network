package com.dcat23.learningnetwork.exception;

import org.springframework.http.HttpStatus;

public abstract class ProjectException extends RuntimeException {
    public ProjectException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatusCode();
}
