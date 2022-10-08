package com.example.involvementsystem.mapper;

import com.example.involvementsystem.dto.MemberRatingResponse;
import com.example.involvementsystem.projection.MemberRatingView;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class MemberRatingViewToResponse implements Converter<MemberRatingView, MemberRatingResponse> {
    @Override
    public MemberRatingResponse convert(MemberRatingView source) {
        return MemberRatingResponse.builder()
                .id(source.getId())
                .fullName(source.getFullName())
                .rating(source.getRatingSum())
                .build();
    }
}
