package com.example.involvementsystem.controller;

import com.example.involvementsystem.api.UserApi;
import com.example.involvementsystem.dto.UserEnableRequest;
import com.example.involvementsystem.dto.UserPageResponse;
import com.example.involvementsystem.dto.UserRequest;
import com.example.involvementsystem.dto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

    @Override
    public ResponseEntity<UserPageResponse> getUsers(Integer page, Integer size) {
        return ResponseEntity.ok(new UserPageResponse());
    }

    @Override
    public ResponseEntity<UserResponse> updateUser(Long id, UserRequest userRequest) {
        return ResponseEntity.ok(new UserResponse());
    }

    @Override
    public ResponseEntity<UserResponse> createUser(UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponse());
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long id) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<UserResponse> enableUser(Long id, UserEnableRequest userEnableRequest) {
        return ResponseEntity.ok(new UserResponse());
    }

    @Override
    public ResponseEntity<UserResponse> getUserById(Long id) {
        return ResponseEntity.ok(new UserResponse());
    }

}
