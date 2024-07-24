package com.dcat23.learningnetwork.users.controller;

import com.dcat23.learningnetwork.users.dto.UserLoginDTO;
import com.dcat23.learningnetwork.users.dto.UserRegistrationDTO;
import com.dcat23.learningnetwork.users.dto.UserResponse;
import com.dcat23.learningnetwork.users.dto.UserUpdateDTO;
import com.dcat23.learningnetwork.users.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    
    @PostMapping("/register")
    public ResponseEntity<UserResponse>registerUser(@Valid @RequestBody UserRegistrationDTO userDTO){
        UserResponse user = userService.registerUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid @RequestBody UserLoginDTO userLoginDTO){
        userService.loginUser(userLoginDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Login Successful");
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@Valid @RequestBody UserUpdateDTO userUpdateDTO){
        UserResponse updatedUser = userService.updateUser(userUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

}
