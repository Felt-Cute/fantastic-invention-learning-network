package com.dcat23.learningnetwork.users.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.lang.NonNull;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

import static com.dcat23.learningnetwork.users.security.SecurityConstants.JWT_HEADER;

public class CorsConfigurationSourceImpl implements CorsConfigurationSource {

    @Override
    public CorsConfiguration getCorsConfiguration(@NonNull HttpServletRequest request) {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
        config.setAllowedMethods(Collections.singletonList("*"));
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setMaxAge(3600L);
        config.setExposedHeaders(Collections.singletonList(JWT_HEADER));
        return config;
    }
}
