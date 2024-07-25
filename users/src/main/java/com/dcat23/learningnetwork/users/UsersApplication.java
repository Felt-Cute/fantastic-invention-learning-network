package com.dcat23.learningnetwork.users;

import com.dcat23.learningnetwork.users.model.Role;
import com.dcat23.learningnetwork.users.model.UserEntity;
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
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
@EnableWebSecurity(debug = true)
public class UsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            String pwd = passwordEncoder.encode("thisisabadpassword");
            UserEntity admin = createAdmin(pwd);
            UserEntity student = createStudent(pwd);
            UserEntity educator = createEducator(pwd);
            userRepository.saveAll(List.of(admin, student, educator));

        };
    }

    private UserEntity createEducator(String password) {
        UserEntity educator = new UserEntity();
        educator.setUsername("educator");
        educator.setPassword(password);
        educator.setEmail("educator@filn.com");
        educator.addRoles(Role.EDUCATOR);
        return educator;
    }

    private UserEntity createStudent(String password) {
        UserEntity student = new UserEntity();
        student.setUsername("student");
        student.setPassword(password);
        student.setEmail("student@filn.com");
        student.addRoles(Role.STUDENT);
        return student;
    }

    private UserEntity createAdmin(String password) {
        UserEntity user = new UserEntity();
        user.setUsername("dcat23");
        user.setPassword(password);
        user.setEmail("dcat@filn.com");
        user.addRoles(Role.ADMIN);
        return user;
    }
}
