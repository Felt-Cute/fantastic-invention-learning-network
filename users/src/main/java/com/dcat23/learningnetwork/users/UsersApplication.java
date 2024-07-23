package com.dcat23.learningnetwork.users;

import com.dcat23.learningnetwork.users.model.User;
import com.dcat23.learningnetwork.users.model.UserRole;
import com.dcat23.learningnetwork.users.repository.UserRepository;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@OpenAPIDefinition(
    info = @Info(
        title = "Users Application REST API Documentation",
        description = "Handles user registration, login, and profile management.",
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
public class UsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String pwd = passwordEncoder.encode("password");
            User admin = createAdmin(pwd);
            User student = createStudent(pwd);
            User educator = createEducator(pwd);
            userRepository.saveAll(List.of(admin, student, educator));

        };
    }

    private User createEducator(String password) {
        User educator = new User();
        educator.setUsername("educator");
        educator.setPassword(password);
        educator.setEmail("educator@myself.com");
        educator.setRole(UserRole.EDUCATOR);
        return educator;
    }

    private User createStudent(String password) {
        User student = new User();
        student.setUsername("student");
        student.setPassword(password);
        student.setEmail("student@myself.com");
        student.setRole(UserRole.STUDENT);
        return student;
    }

    private User createAdmin(String password) {
        User user = new User();
        user.setUsername("dcat23");
        user.setPassword(password);
        user.setEmail("dcat@myself.com");
        user.setRole(UserRole.ADMIN);
        return user;
    }
}
