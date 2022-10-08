package com.example.involvementsystem.service;

import com.example.involvementsystem.dto.MemberPageRequest;
import com.example.involvementsystem.dto.MemberRatingPageResponse;
import com.example.involvementsystem.dto.MemberRatingResponse;
import com.example.involvementsystem.dto.MemberResponse;

import java.util.List;

public interface MemberService {
    List<MemberRatingResponse> getTop();

    MemberRatingPageResponse getAll(MemberPageRequest request);

    MemberResponse getById(Long memberId);
}
