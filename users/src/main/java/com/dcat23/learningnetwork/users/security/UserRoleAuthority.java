package com.dcat23.learningnetwork.users.security;

import com.dcat23.learningnetwork.users.model.Role;
import org.springframework.security.core.GrantedAuthority;

public record UserRoleAuthority(Role role) implements GrantedAuthority {
    /**
     * @return Role name
     */
    @Override
    public String getAuthority() {
        return "Role_" + role.name();
    }
}
