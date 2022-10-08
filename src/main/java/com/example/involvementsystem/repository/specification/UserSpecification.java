package com.example.involvementsystem.repository.specification;

import com.example.involvementsystem.model.Department;
import com.example.involvementsystem.model.Guild;
import com.example.involvementsystem.model.Level;
import com.example.involvementsystem.model.Position;
import com.example.involvementsystem.model.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class UserSpecification {

    public static Specification<User> like(String name, String value) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get(name)), "%" + value.toLowerCase() + "%");
    }

    public static Specification<User> equal(Department value) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("department"), value);
    }

    public static Specification<User> equal(Position value) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("position"), value);
    }

    public static Specification<User> equal(Guild value) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("guilg"), value);
    }

    public static Specification<User> equal(Level value) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("level"), value);
    }
}
