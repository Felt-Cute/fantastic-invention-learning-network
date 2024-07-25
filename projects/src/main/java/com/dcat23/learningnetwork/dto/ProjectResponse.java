package com.dcat23.learningnetwork.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;

@Schema(
    name = "ProjectResponse",
    description = "Schema to hold Project details")
public record ProjectResponse(
        Long projectId,
        String title,
        String description,
        Long ownerId,
        Set<Long> members
) {
}
