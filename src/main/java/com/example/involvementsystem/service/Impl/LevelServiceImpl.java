package com.example.involvementsystem.service.Impl;

import com.example.involvementsystem.dto.LevelResponse;
import com.example.involvementsystem.repository.LevelRepository;
import com.example.involvementsystem.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;

    private final ConversionService conversionService;

    @Override
    public List<LevelResponse> getAll() {
        return levelRepository.findLevels().stream()
                .map(e -> conversionService.convert(e, LevelResponse.class))
                .collect(Collectors.toList());
    }
}
