package com.dcat23.learningnetwork.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    name = "AuthResponse",
    description = "Schema to hold JWT token")
public record AuthResponseDTO(
        String accessToken
) {
    public String tokenType() {
        return "Bearer ";
    }
}
