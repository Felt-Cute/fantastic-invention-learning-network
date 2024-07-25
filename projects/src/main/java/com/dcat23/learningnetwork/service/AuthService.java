package com.dcat23.learningnetwork.service;

import com.dcat23.learningnetwork.dto.LoginRequest;
import com.dcat23.learningnetwork.dto.LoginResponse;
import com.dcat23.learningnetwork.security.JwtToken;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AuthService {

    private final UserServiceClient userService;
    private final JwtToken jwtToken;

    public void authenticate(LoginRequest loginRequest) {
        LoginResponse jwtResponse = userService.login(loginRequest);
        jwtToken.setToken(jwtResponse.accessToken());
        log.debug("✅Authenticated: {}", loginRequest.email());
    }
}
