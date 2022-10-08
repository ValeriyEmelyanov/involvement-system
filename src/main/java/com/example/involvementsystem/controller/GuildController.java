package com.example.involvementsystem.controller;

import com.example.involvementsystem.api.GuildApi;
import com.example.involvementsystem.dto.GuildResponse;
import com.example.involvementsystem.service.GuildService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GuildController implements GuildApi {

    private final GuildService guildService;

    @Override
    public ResponseEntity<List<GuildResponse>> getGuilds() {
        return ResponseEntity.ok(guildService.getAll());
    }
}
