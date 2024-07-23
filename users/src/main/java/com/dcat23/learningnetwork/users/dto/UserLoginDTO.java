package com.dcat23.learningnetwork.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    name = "UserLogin",
    description = "Schema to hold User Login details")
public record UserLoginDTO() {
}
