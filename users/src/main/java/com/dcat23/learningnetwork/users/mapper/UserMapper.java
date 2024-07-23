package com.dcat23.learningnetwork.users.mapper;

import com.dcat23.learningnetwork.users.dto.UserRegistrationDTO;
import com.dcat23.learningnetwork.users.dto.UserResponse;
import com.dcat23.learningnetwork.users.model.User;
import com.dcat23.learningnetwork.users.model.UserRole;

public class UserMapper {
    public static UserResponse mapToUserResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole()
        );
    }

    public static User mapFromUserRegistrationDTO(UserRegistrationDTO userDTO, User user) {
        user.setUsername(userDTO.username());
        user.setEmail(userDTO.email());
        user.setRole(UserRole.STUDENT);
        return user;
    }
}
