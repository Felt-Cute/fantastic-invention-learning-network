package com.dcat23.learningnetwork.users.service;

import com.dcat23.learningnetwork.users.dto.UserLoginDTO;
import com.dcat23.learningnetwork.users.dto.UserRegistrationDTO;
import com.dcat23.learningnetwork.users.dto.UserResponse;
import com.dcat23.learningnetwork.users.dto.UserUpdateDTO;
import com.dcat23.learningnetwork.users.mapper.UserMapper;
import com.dcat23.learningnetwork.users.model.UserEntity;
import com.dcat23.learningnetwork.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse registerUser(UserRegistrationDTO userDTO) {
        UserEntity user = UserMapper.mapFromUserRegistrationDTO(userDTO, new UserEntity());
        user.setPassword(passwordEncoder.encode(userDTO.password()));
        UserEntity saved = userRepository.save(user);
        return UserMapper.mapToUserResponse(saved);
    }

    @Override
    public UserResponse loginUser(UserLoginDTO userLoginDTO) {
        return null;
    }

    @Override
    public UserResponse updateUser(UserUpdateDTO userUpdateDTO) {
        return null;
    }
}
