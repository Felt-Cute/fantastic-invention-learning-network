package com.dcat23.learningnetwork.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    name = "LoginRequest",
    description = "Schema to hold Login Request details")
public record LoginRequest(
        String email,
        String password
) {
}
