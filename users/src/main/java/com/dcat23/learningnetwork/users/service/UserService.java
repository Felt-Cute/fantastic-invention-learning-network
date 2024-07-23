package com.dcat23.learningnetwork.users.service;

import com.dcat23.learningnetwork.users.dto.UserLoginDTO;
import com.dcat23.learningnetwork.users.dto.UserRegistrationDTO;
import com.dcat23.learningnetwork.users.dto.UserResponse;
import com.dcat23.learningnetwork.users.dto.UserUpdateDTO;

public interface UserService {

    UserResponse registerUser(UserRegistrationDTO userDTO);

    UserResponse loginUser(UserLoginDTO userLoginDTO);

    UserResponse updateUser(UserUpdateDTO userUpdateDTO);
}
