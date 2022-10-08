package com.example.involvementsystem.controller;

import com.example.involvementsystem.api.DepartmentApi;
import com.example.involvementsystem.dto.DepartmentResponse;
import com.example.involvementsystem.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController implements DepartmentApi {

    private final DepartmentService departmentService;

    @Override
    public ResponseEntity<List<DepartmentResponse>> getDepartments() {
        return ResponseEntity.ok(departmentService.getAll());
    }

    @Override
    public ResponseEntity<List<DepartmentResponse>> getDepartmentsByParentId(Long parentId) {
        return ResponseEntity.ok(departmentService.getByParentId(parentId));
    }
}
