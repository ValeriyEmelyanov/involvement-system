package com.example.involvementsystem.mapper;

import com.example.involvementsystem.dto.MemberRatingResponse;
import com.example.involvementsystem.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MemberToRatingResponse implements Converter<User, MemberRatingResponse> {
    @Override
    public MemberRatingResponse convert(User source) {
        return MemberRatingResponse.builder()
                .id(source.getId())
                .fullName(source.getFullName())
                .rating(source.getRating() == null ? 0 : source.getRating().getSum())
                .build();
    }
}
