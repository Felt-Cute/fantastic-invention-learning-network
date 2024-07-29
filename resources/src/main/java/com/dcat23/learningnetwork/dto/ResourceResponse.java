package com.dcat23.learningnetwork.dto;

import java.time.LocalDateTime;

public record ResourceResponse (

    Long id,

    Long projectId,

    String title,

    String fileUrl,

    Long uploadedByUserId,

    LocalDateTime createdAt
) {
}

