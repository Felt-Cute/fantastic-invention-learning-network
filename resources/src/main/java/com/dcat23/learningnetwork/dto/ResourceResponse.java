package com.dcat23.learningnetwork.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record ResourceResponse (

    @JsonProperty("id")
    Long id,

    @JsonProperty("project_id")
    Long projectId,

    @JsonProperty("title")
    String title,

    @JsonProperty("file_url")
    String fileUrl,

    @JsonProperty("uploaded_by_user_id")
    Long uploadedByUserId,

    @JsonProperty("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime createdAt
) {
}

