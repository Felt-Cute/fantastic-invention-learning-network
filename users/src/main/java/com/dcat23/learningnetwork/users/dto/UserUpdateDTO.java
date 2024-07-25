package com.dcat23.learningnetwork.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;

@Schema(
    name = "UserUpdate",
    description = "Schema to hold updated User details")
public record UserUpdateDTO(

        @Schema(description = "username - at least 4 characters", example = "nacho_supreme16")
        @Min(value = 4, message = "username must have 4 characters")
        String username,

        @Schema(description = "email - must be unique", example = "contact@filn.com")
        @Email
        String email,

        @Schema(description = "password - at least 8 characters", example = "thisisabadpassword")
        @Min(value = 8, message = "password must have more than 8 characters")
        String password
) {
}
