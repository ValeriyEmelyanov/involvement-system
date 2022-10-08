package com.example.involvementsystem.mapper;

import com.example.involvementsystem.dto.GuildResponse;
import com.example.involvementsystem.dto.MemberRatingResponse;
import com.example.involvementsystem.model.Guild;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GuildToResponse implements Converter<Guild, GuildResponse> {
    @Override
    public GuildResponse convert(Guild source) {
        return GuildResponse.builder()
                .id(source.getId())
                .name(source.getName())
                .build();
    }
}
