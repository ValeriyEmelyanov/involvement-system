package com.example.involvementsystem.repository;

import com.example.involvementsystem.model.Level;
import com.example.involvementsystem.projection.LevelView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {

    @Query(nativeQuery = true,
    value = "SELECT " +
            "l.id id, " +
            "l.level_name levelName, " +
            "g.guild_name guildName, " +
            "l.min_rating minRating " +
            "FROM level AS l " +
            "LEFT JOIN guild AS g ON l.guild_id = g.id")
    List<LevelView> findLevels();

}
