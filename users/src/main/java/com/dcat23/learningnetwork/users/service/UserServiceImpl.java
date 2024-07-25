package com.dcat23.learningnetwork.users.service;

import com.dcat23.learningnetwork.users.dto.*;
import com.dcat23.learningnetwork.users.exception.UserNotFoundException;
import com.dcat23.learningnetwork.users.mapper.UserMapper;
import com.dcat23.learningnetwork.users.model.UserEntity;
import com.dcat23.learningnetwork.users.repository.UserRepository;
import com.dcat23.learningnetwork.users.security.JwtTokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserServiceImpl implements UserService {

    @Value("${jwt.secret}")
    private String jwtSecret;

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
    public LoginResponse loginUser(UserLoginDTO userLoginDTO) {
        Authentication auth = authenticateLogin(userLoginDTO);
        if (auth == null || !auth.isAuthenticated()) {
            throw new BadCredentialsException("Username or password is incorrect");
        }
        String token = JwtTokenGenerator.generateToken(auth, jwtSecret);
        return new LoginResponse(token);
    }

    private Authentication authenticateLogin(UserLoginDTO userLoginDTO) {
        return authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken.unauthenticated(
                        userLoginDTO.email(),
                        userLoginDTO.password()
                )
        );
    }

    @Override
    public UserResponse updateUser(UserUpdateDTO userUpdateDTO) {
        return null;
    }

    /**
     * @param id the User id
     * @return UserResponse with user details
     */
    @Override
    public UserResponse getUserById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return UserMapper.mapToUserResponse(user);
    }

    /**
     * Retrieves the user information after a successful login.
     *
     * @param auth the authentication object containing the user's credentials and details.
     * @return a UserResponse object containing the user's information, or null if authentication fails.
     */
    @Override
    public UserResponse getUserAfterLogin(Authentication auth) {
        UserEntity user = userRepository.findByEmail(auth.getName())
                .orElse(null);
        return UserMapper.mapToUserResponse(user);
    }
}
