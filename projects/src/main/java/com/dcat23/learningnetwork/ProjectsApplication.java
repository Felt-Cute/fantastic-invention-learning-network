package com.dcat23.learningnetwork;

import com.dcat23.learningnetwork.dto.LoginRequest;
import com.dcat23.learningnetwork.security.JwtToken;
import com.dcat23.learningnetwork.service.AuthService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(
    info = @Info(
        title = "Projects Application REST API Documentation",
        description = "Manages creation, retrieval, updating, and deletion of projects.",
        version = "v1",
        contact = @Contact(
            name = "Devin Catuns",
            email = "devincatuns1@gmail.com",
            url = "https://github.com/dcat23"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0"
        )
    ),
    externalDocs = @ExternalDocumentation(
        description = "Fantastic Invention Learning Network Github",
        url = "https://github.com/Felt-Cute/fantastic-invention-learning-network"
    ))
@SpringBootApplication
@EnableFeignClients
public class ProjectsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectsApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AuthService authService) {
        return args -> {
            LoginRequest loginRequest = new LoginRequest("dcat@filn.com", "thisisabadpassword");
            authService.authenticate(loginRequest);
        };
    }

    @Bean
    public JwtToken jwtToken() {
        return new JwtToken();
    }
}