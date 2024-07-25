package com.dcat23.learningnetwork.exception;

import org.springframework.http.HttpStatus;

public class AlreadyAddedException extends ProjectException {
    public AlreadyAddedException(String memberName) {
        super(String.format("Member '%s' already added to project", memberName));
    }

    public AlreadyAddedException(Long memberId) {
        super(String.format("Member with id '%d' already added to project", memberId));
    }

    /**
     * @return HttpStatus Code response
     */
    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.BAD_REQUEST;
    }
}
