package com.example.involvementsystem.service;

import com.example.involvementsystem.dto.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    List<DepartmentResponse> getAll();

    List<DepartmentResponse> getByParentId(Long parentId);
}
