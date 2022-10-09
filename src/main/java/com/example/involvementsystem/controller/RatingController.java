package com.example.involvementsystem.controller;

import com.example.involvementsystem.api.RatingApi;
import com.example.involvementsystem.dto.RatingOperationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RatingController implements RatingApi {
    @Override
    public ResponseEntity<List<RatingOperationResponse>> getRatings(Integer page, Integer size, String fromDate, String toDate) {
        return ResponseEntity.ok(List.of());
    }
}
