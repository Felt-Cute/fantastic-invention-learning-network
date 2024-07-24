package com.dcat23.learningnetwork.users.dto;

import com.dcat23.learningnetwork.users.model.Role;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;

@Schema(
    name = "UserResponse",
    description = "Schema to hold User details")
public record UserResponse(
        Long id,

        String username,

        String email,

        Set<Role> roles
) {
}
