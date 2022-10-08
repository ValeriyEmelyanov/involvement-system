package com.example.involvementsystem.repository;

import com.example.involvementsystem.model.User;
import com.example.involvementsystem.projection.MemberRatingView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query(nativeQuery = true,
            value = "SELECT " +
                    "u.id Id, " +
                    "u.full_name fullName, " +
                    "r.sum ratingSum " +
                    "FROM Users AS u " +
                    "LEFT JOIN rating AS r ON u.id = r.user_id " +
                    "ORDER BY r.sum DESC " +
                    "LIMIT 20")
    List<MemberRatingView> findTop();
}
