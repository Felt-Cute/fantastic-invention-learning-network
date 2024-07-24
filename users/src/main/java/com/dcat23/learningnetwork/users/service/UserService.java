package com.dcat23.learningnetwork.users.service;

import com.dcat23.learningnetwork.users.dto.*;

public interface UserService {

    UserResponse registerUser(UserRegistrationDTO userDTO);

    AuthResponseDTO loginUser(UserLoginDTO userLoginDTO);

    UserResponse updateUser(UserUpdateDTO userUpdateDTO);

//    UserResponse getUserById(Long id);
}
