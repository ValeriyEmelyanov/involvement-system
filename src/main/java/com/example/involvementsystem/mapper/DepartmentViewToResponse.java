package com.example.involvementsystem.mapper;

import com.example.involvementsystem.dto.DepartmentResponse;
import com.example.involvementsystem.model.Department;
import com.example.involvementsystem.projection.DepartmentView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DepartmentViewToResponse implements Converter<DepartmentView, DepartmentResponse> {
    @Override
    public DepartmentResponse convert(DepartmentView source) {
        return DepartmentResponse.builder()
                .id(source.getId())
                .name(source.getDepartmentName())
                .parentId(source.getParentId())
                .head(source.getHead())
                .build();
    }
}
