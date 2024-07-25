package com.dcat23.learningnetwork.exception;

import org.springframework.http.HttpStatus;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException(Long id) {
        super(String.format("Project with id %s not found", id));
    }

    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
