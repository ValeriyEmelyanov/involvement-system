package com.example.involvementsystem.controller;

import com.example.involvementsystem.api.UserApi;
import com.example.involvementsystem.dto.UserRequest;
import com.example.involvementsystem.dto.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    @Override
    public ResponseEntity<UserResponse> createUser(UserRequest userRequest) {
        return ResponseEntity.ok(new UserResponse());
    }

}
