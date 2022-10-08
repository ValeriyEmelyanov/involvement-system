package com.example.involvementsystem.mapper;

import com.example.involvementsystem.dto.MemberResponse;
import com.example.involvementsystem.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MemberToResponse implements Converter<User, MemberResponse> {
    @Override
    public MemberResponse convert(User source) {
        return MemberResponse.builder()
                .id(source.getId())
                .fullName(source.getFullName())
                .rating(source.getRating().getSum())
                .phone(source.getPhone())
                .email(source.getEmail())
                .department(source.getDepartment().getName())
                .position(source.getPosition().getName())
                .guild(source.getGuild().getName())
                .level(source.getLevel().getName())
                .publicKey(source.getPublicKey())
                .build();
    }
}
