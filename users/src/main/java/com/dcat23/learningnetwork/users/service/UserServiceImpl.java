package com.dcat23.learningnetwork.users.service;

import com.dcat23.learningnetwork.users.dto.UserLoginDTO;
import com.dcat23.learningnetwork.users.dto.UserRegistrationDTO;
import com.dcat23.learningnetwork.users.dto.UserResponse;
import com.dcat23.learningnetwork.users.dto.UserUpdateDTO;
import com.dcat23.learningnetwork.users.mapper.UserMapper;
import com.dcat23.learningnetwork.users.model.UserEntity;
import com.dcat23.learningnetwork.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserResponse registerUser(UserRegistrationDTO userDTO) {
        UserEntity user = UserMapper.mapFromUserRegistrationDTO(userDTO, new UserEntity());
        user.setPassword(passwordEncoder.encode(userDTO.password()));
        UserEntity saved = userRepository.save(user);
        return UserMapper.mapToUserResponse(saved);
    }

    @Override
    public void loginUser(UserLoginDTO userLoginDTO) {
        Authentication auth = authenticateLogin(userLoginDTO);
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    private Authentication authenticateLogin(UserLoginDTO userLoginDTO) {
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLoginDTO.email(),
                        userLoginDTO.password()
                )
        );
    }

    @Override
    public UserResponse updateUser(UserUpdateDTO userUpdateDTO) {
        return null;
    }
}
