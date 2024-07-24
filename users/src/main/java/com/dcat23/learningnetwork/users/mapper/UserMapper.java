package com.dcat23.learningnetwork.users.mapper;

import com.dcat23.learningnetwork.users.dto.UserRegistrationDTO;
import com.dcat23.learningnetwork.users.dto.UserResponse;
import com.dcat23.learningnetwork.users.model.Role;
import com.dcat23.learningnetwork.users.model.UserEntity;

public class UserMapper {
    public static UserResponse mapToUserResponse(UserEntity user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRoles()
        );
    }

    public static UserEntity mapFromUserRegistrationDTO(UserRegistrationDTO userDTO, UserEntity user) {
        user.setUsername(userDTO.username());
        user.setEmail(userDTO.email());
        user.addRoles(Role.STUDENT);
        return user;
    }
}
