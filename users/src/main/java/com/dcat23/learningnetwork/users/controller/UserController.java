package com.dcat23.learningnetwork.users.controller;

import com.dcat23.learningnetwork.users.dto.*;
import com.dcat23.learningnetwork.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import static com.dcat23.learningnetwork.users.security.SecurityConstants.JWT_HEADER;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @Operation(
            summary = "Register User",
            description = "REST API to register a new User")
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status CREATED")
    public ResponseEntity<UserResponse>registerUser(@Valid @RequestBody UserRegistrationDTO userDTO){
        UserResponse user = userService.registerUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    @Operation(
            summary = "Login User",
            description = "REST API to login with username and password")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody UserLoginDTO userLoginDTO){
        LoginResponse authResponse = userService.loginUser(userLoginDTO);
        return ResponseEntity.status(HttpStatus.OK)
                .header(JWT_HEADER)
                .body(authResponse);
    }

    @Operation(
            summary = "Get User After Login",
            description = "REST API to FETCH authorized User details")
    @GetMapping("/user")
    public ResponseEntity<UserResponse> getUserAfterLogin(Authentication auth){
        UserResponse user = userService.getUserAfterLogin(auth);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update User",
            description = "REST API to update User details")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK")
    public ResponseEntity<UserResponse> updateUser(@Valid @RequestBody UserUpdateDTO userUpdateDTO){
        UserResponse updatedUser = userService.updateUser(userUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get User By Id",
            description = "REST API to FETCH a User")
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id){
        UserResponse user = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
