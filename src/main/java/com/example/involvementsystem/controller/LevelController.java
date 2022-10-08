package com.example.involvementsystem.controller;

import com.example.involvementsystem.api.LevelApi;
import com.example.involvementsystem.dto.LevelResponse;
import com.example.involvementsystem.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LevelController implements LevelApi {

    private final LevelService levelService;

    @Override
    public ResponseEntity<List<LevelResponse>> getLevels() {
        return ResponseEntity.ok(levelService.getAll());
    }
}
