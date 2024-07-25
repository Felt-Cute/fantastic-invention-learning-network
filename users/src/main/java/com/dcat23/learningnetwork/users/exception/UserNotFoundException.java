package com.dcat23.learningnetwork.users.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super(String.format("User id '%d' not found", id));
    }
}
