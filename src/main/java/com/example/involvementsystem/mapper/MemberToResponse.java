package com.example.involvementsystem.mapper;

import com.example.involvementsystem.dto.GuildInfoResponse;
import com.example.involvementsystem.dto.MemberResponse;
import com.example.involvementsystem.model.Role;
import com.example.involvementsystem.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class MemberToResponse implements Converter<User, MemberResponse> {
    @Override
    public MemberResponse convert(User source) {
        return MemberResponse.builder()
                .id(source.getId())
                .fullName(source.getFullName())
                .rating(source.getRating() == null ? 0 : source.getRating().getSum())
                .phone(source.getPhone())
                .email(source.getEmail())
                .department(source.getDepartment().getName())
                .position(source.getPosition().getName())
                .guildInfos(source.getGuildInfos().stream()
                        .map(e -> new GuildInfoResponse(e.getGuild().getName(), e.getLevel().getName()))
                        .collect(Collectors.toList()))
                .roles(source.getRoles().stream()
                        .map(Role::name)
                        .collect(Collectors.toList()))
                .publicKey(source.getPublicKey())
                .build();
    }
}
