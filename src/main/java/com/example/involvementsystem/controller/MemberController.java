package com.example.involvementsystem.controller;

import com.example.involvementsystem.api.MemberApi;
import com.example.involvementsystem.dto.MemberPageRequest;
import com.example.involvementsystem.dto.MemberRatingPageResponse;
import com.example.involvementsystem.dto.MemberRatingResponse;
import com.example.involvementsystem.dto.MemberResponse;
import com.example.involvementsystem.model.Department;
import com.example.involvementsystem.model.Guild;
import com.example.involvementsystem.model.Level;
import com.example.involvementsystem.model.Position;
import com.example.involvementsystem.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController implements MemberApi {

    private final MemberService memberService;

    @Override
    public ResponseEntity<MemberResponse> getMemberById(Long id) {
        return ResponseEntity.ok(memberService.getById(id));
    }

    @Override
    public ResponseEntity<MemberRatingPageResponse> getMembers(
            Integer page, Integer size,
            String fullName, Long departmentId, Long positionId, Long guildId, Long levelId) {
        MemberPageRequest request = getMemberPageRequest(
                page,
                size,
                fullName,
                departmentId,
                positionId,
                guildId,
                levelId);
        return ResponseEntity.ok(memberService.getAll(request));
    }

    @Override
    public ResponseEntity<List<MemberRatingResponse>> getMembersTop() {
        return ResponseEntity.ok(memberService.getTop());
    }

    private static MemberPageRequest getMemberPageRequest(
            Integer page,
            Integer size,
            String fullName,
            Long departmentId,
            Long positionId,
            Long guildId,
            Long levelId) {
        MemberPageRequest.MemberPageRequestBuilder builder = MemberPageRequest.builder();
        if (departmentId != null) {
            Department department = new Department();
            department.setId(departmentId);
            builder.department(department);
        }
        if (positionId != null) {
            Position position = new Position();
            position.setId(positionId);
            builder.position(position);
        }
        if (guildId != null) {
            Guild guild = new Guild();
            guild.setId(guildId);
            builder.guild(guild);
        }
        if (levelId != null) {
            Level level = new Level();
            level.setId(levelId);
            builder.level(level);
        }

        return builder
                .page(page)
                .size(size)
                .fullName(fullName)
                .build();
    }
}
