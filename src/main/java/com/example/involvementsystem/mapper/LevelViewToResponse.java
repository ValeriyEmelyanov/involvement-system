package com.example.involvementsystem.mapper;

import com.example.involvementsystem.dto.LevelResponse;
import com.example.involvementsystem.projection.LevelView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LevelViewToResponse implements Converter<LevelView, LevelResponse> {
    @Override
    public LevelResponse convert(LevelView source) {
        return LevelResponse.builder()
                .id(source.getId())
                .name(source.getLevelName())
                .guildName(source.getGuildName())
                .minRating(source.getMinRating())
                .build();
    }
}
