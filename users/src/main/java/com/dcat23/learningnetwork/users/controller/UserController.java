package com.dcat23.learningnetwork.users.controller;

import com.dcat23.learningnetwork.users.dto.*;
import com.dcat23.learningnetwork.users.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class UserController {

    private final UserService userService;
    
    @PostMapping("/register")
    public ResponseEntity<UserResponse>registerUser(@Valid @RequestBody UserRegistrationDTO userDTO){
        UserResponse user = userService.registerUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> loginUser(@Valid @RequestBody UserLoginDTO userLoginDTO){
        AuthResponseDTO authResponse = userService.loginUser(userLoginDTO);
        return ResponseEntity.status(HttpStatus.OK).body(authResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@Valid @RequestBody UserUpdateDTO userUpdateDTO){
        UserResponse updatedUser = userService.updateUser(userUpdateDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id){
//        UserResponse user = userService.getUserById(id);
//        return ResponseEntity.status(HttpStatus.OK).body(user);
//    }

}
