package com.dcat23.learningnetwork.users.service;

import com.dcat23.learningnetwork.users.dto.*;
import org.springframework.security.core.Authentication;

public interface UserService {

    UserResponse registerUser(UserRegistrationDTO userDTO);

    LoginResponse loginUser(UserLoginDTO userLoginDTO);

    UserResponse updateUser(UserUpdateDTO userUpdateDTO);

    UserResponse getUserById(Long id);

    UserResponse getUserAfterLogin(Authentication auth);
}
