package com.example.involvementsystem.service.Impl;

import com.example.involvementsystem.dto.PositionResponse;
import com.example.involvementsystem.repository.PositionRepository;
import com.example.involvementsystem.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    private final ConversionService conversionService;

    @Override
    public List<PositionResponse> getAll() {
        return positionRepository.findAll().stream()
                .map(e -> conversionService.convert(e, PositionResponse.class))
                .collect(Collectors.toList());
    }
}
