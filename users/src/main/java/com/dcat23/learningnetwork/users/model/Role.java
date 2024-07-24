package com.dcat23.learningnetwork.users.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {
    STUDENT,
    EDUCATOR,
    ADMIN;

    public GrantedAuthority authority() {
        return new SimpleGrantedAuthority(this.name());
    }
}
