package com.example.involvementsystem.controller;

import com.example.involvementsystem.api.AuthApi;
import com.example.involvementsystem.dto.AuthRequest;
import com.example.involvementsystem.dto.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApi {

    @Override
    public ResponseEntity<AuthResponse> auth(AuthRequest authResponse) {
        return ResponseEntity.ok(new AuthResponse("some_token"));
    }

}
