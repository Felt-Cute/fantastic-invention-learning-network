package com.dcat23.learningnetwork.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(
    name = "ProjectUpdate",
    description = "Schema to hold updated project details")
public record ProjectUpdateDTO(

        @Schema(description = "new title for the Project")
        @NotBlank(message = "title must not be empty")
        String title,

        @Schema(description = "New Project description")
        @NotBlank(message = "Description must not be empty")
        String description,

        Long ownerId
) {
}
