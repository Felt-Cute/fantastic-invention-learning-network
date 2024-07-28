package com.dcat23.learningnetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/filn/users/**")
                        .filters(f -> f.rewritePath("/filn/users/(?<segment>.*)", "/api/users/${segment}"))
                        .uri("lb://USERS"))
                .route(p -> p
                        .path("/filn/projects/**")
                        .filters(f -> f.rewritePath("/filn/projects/(?<segment>.*)", "/api/projects/${segment}"))
                        .uri("lb://PROJECTS"))
                .build();

    }
}