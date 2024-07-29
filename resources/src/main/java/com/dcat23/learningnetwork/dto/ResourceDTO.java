package com.dcat23.learningnetwork.dto;

public record ResourceDTO(
        String title,
        String fileUrl,
        Long projectId,
        Long userId
) {
}
