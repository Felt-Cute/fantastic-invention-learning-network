package com.dcat23.learningnetwork.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;

@Schema(
    name = "UserLogin",
    description = "Schema to hold User Login details")
public record UserLoginDTO(

        @Schema(description = "User email", example = "gm@il.com")
        @Email(message = "Must provide a valid email")
        String email,

        @Schema(description = "User password - at least 8 characters", example = "thisisabadpassword")
        String password
) {
}
