package com.dcat23.learningnetwork.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    name = "LoginResponse",
    description = "Schema to hold authentication token")
public record LoginResponse(
        String accessToken
) {
}
