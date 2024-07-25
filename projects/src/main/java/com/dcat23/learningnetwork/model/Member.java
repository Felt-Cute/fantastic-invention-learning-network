package com.dcat23.learningnetwork.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Set;

@Schema(
    name = "Member",
    description = "Schema to hold Member from user service")
public record Member(
        Long id,
        String username,
        String email,
        Set<String> roles
) {
}
