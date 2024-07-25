package com.dcat23.learningnetwork.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(
    name = "ProjectCreation",
    description = "Schema to hold initial project details")
public record ProjectCreationDTO(

        @Schema(description = "The Project title")
        @NotBlank(message = "Title must not be empty")
        String title,

        @Schema(description = "The Project description")
        @NotBlank(message = "description must not be empty")
        String description,

        @Schema(description = "The owner id (user.id)")
        @NotNull(message = "The ownerId must not be null")
        Long ownerId
) {
}
