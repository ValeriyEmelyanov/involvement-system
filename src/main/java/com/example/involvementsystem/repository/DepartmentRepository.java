package com.example.involvementsystem.repository;

import com.example.involvementsystem.model.Department;
import com.example.involvementsystem.projection.DepartmentView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query(nativeQuery = true,
    value = "SELECT " +
            "d.id id, " +
            "d.department_name departmentName, " +
            "d.parent_id parentId, " +
            "u.full_name head " +
            "FROM department AS d " +
            "LEFT JOIN users AS u ON d.head_id = u.id")
    List<DepartmentView> findDepartments();

    @Query(nativeQuery = true,
    value = "SELECT " +
            "d.id id, " +
            "d.department_name departmentName, " +
            "d.parent_id parentId, " +
            "u.full_name head " +
            "FROM department AS d " +
            "LEFT JOIN users AS u ON d.head_id = u.id " +
    "WHERE d.parent_id = :parentId")
    List<DepartmentView> findDepartmentsByParentId(Long parentId);
}
