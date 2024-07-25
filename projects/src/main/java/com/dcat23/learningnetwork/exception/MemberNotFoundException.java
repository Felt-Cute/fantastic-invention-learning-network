package com.dcat23.learningnetwork.exception;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(Long memberId) {
        super("Member with id '" + memberId + "' not found");
    }
}
