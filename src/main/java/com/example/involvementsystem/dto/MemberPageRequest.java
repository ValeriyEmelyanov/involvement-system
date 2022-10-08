package com.example.involvementsystem.dto;

import com.example.involvementsystem.model.Department;
import com.example.involvementsystem.model.Guild;
import com.example.involvementsystem.model.Level;
import com.example.involvementsystem.model.Position;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberPageRequest {
    private final Integer page;
    private final Integer size;
    private final String fullName;
    private final Department department;
    private final Position position;
    private final Guild guild;
    private final Level level;
}
