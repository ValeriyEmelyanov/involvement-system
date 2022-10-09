package com.example.involvementsystem.controller;

import com.example.involvementsystem.api.WalletApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController implements WalletApi {
    @Override
    public ResponseEntity<Void> createWallet() {
        return ResponseEntity.ok().build();
    }
}
