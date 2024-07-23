package com.dcat23.learningnetwork.users.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.management.relation.Role;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "pwd_hash", nullable = false)
    private String password;

    @Column(name = "role")
    private Role role;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

}
