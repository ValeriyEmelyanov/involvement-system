package com.example.involvementsystem.mapper;

import com.example.involvementsystem.dto.GuildResponse;
import com.example.involvementsystem.dto.PositionResponse;
import com.example.involvementsystem.model.Position;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PositionToResponse implements Converter<Position, PositionResponse> {
    @Override
    public PositionResponse convert(Position source) {
        return PositionResponse.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
