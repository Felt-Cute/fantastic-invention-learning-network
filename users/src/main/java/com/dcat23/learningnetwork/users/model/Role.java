package com.dcat23.learningnetwork.users.model;

import com.dcat23.learningnetwork.users.security.UserRoleAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {
    STUDENT,
    EDUCATOR,
    ADMIN;

    public GrantedAuthority authority() {
        return new UserRoleAuthority(this);
    }
}
