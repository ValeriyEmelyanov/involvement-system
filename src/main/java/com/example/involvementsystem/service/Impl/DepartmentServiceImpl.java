package com.example.involvementsystem.service.Impl;

import com.example.involvementsystem.dto.DepartmentResponse;
import com.example.involvementsystem.projection.DepartmentView;
import com.example.involvementsystem.repository.DepartmentRepository;
import com.example.involvementsystem.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final ConversionService conversionService;

    @Override
    public List<DepartmentResponse> getAll() {
        return departmentRepository.findDepartments().stream()
                .map(e -> conversionService.convert(e, DepartmentResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<DepartmentResponse> getByParentId(Long parentId) {
        return departmentRepository.findDepartmentsByParentId(parentId).stream()
                .map(e -> conversionService.convert(e, DepartmentResponse.class))
                .collect(Collectors.toList());
    }
}
