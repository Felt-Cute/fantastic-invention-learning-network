package com.dcat23.learningnetwork.users.dto;

import com.dcat23.learningnetwork.users.model.UserRole;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    name = "UserResponse",
    description = "Schema to hold User details")
public record UserResponse(
    Long id,

    String username,

    String email,

    String password,

    UserRole role
) {
}
