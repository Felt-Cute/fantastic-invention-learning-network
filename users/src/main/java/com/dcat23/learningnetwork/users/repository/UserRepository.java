package com.dcat23.learningnetwork.users.repository;

import com.dcat23.learningnetwork.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
