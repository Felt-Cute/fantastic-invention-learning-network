package com.dcat23.learningnetwork.users.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    name = "UserUpdate",
    description = "Schema to hold updated User details")
public record UserUpdateDTO() {
}
