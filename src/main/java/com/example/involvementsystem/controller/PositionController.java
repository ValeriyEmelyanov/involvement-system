package com.example.involvementsystem.controller;

import com.example.involvementsystem.api.PositionApi;
import com.example.involvementsystem.dto.PositionResponse;
import com.example.involvementsystem.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PositionController implements PositionApi {

    private final PositionService positionService;

    @Override
    public ResponseEntity<List<PositionResponse>> getPositions() {
        return ResponseEntity.ok(positionService.getAll());
    }
}
