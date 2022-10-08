package com.example.involvementsystem.service.Impl;

import com.example.involvementsystem.dto.GuildResponse;
import com.example.involvementsystem.repository.GuildRepository;
import com.example.involvementsystem.service.GuildService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GuildServiceImpl implements GuildService {

    private final GuildRepository guildRepository;

    private final ConversionService conversionService;

    @Override
    public List<GuildResponse> getAll() {
        return guildRepository.findAll().stream()
                .map(e -> conversionService.convert(e, GuildResponse.class))
                .collect(Collectors.toList());
    }
}
