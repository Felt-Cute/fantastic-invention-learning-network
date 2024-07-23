package com.dcat23.learningnetwork.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Schema(
    name = "UserRegistration",
    description = "Schema to hold User Registration details")
public record UserRegistrationDTO(

        @Schema(description = "username - at least 4 characters", example = "nacho_supreme16")
        @Min(value = 4, message = "username must have 4 characters")
        @NotBlank(message = "username must not be empty")
        String username,

        @Schema(description = "email - must be unique", example = "contact@me.com")
        @Email
        @NotBlank(message = "email must not be empty")
        String email,

        @Schema(description = "password - at least 8 characters", example = "thisisabadpassword")
        @Min(value = 8, message = "password must have more than 8 characters")
        @NotBlank(message = "password must not be empty")
        String password

) {
}
