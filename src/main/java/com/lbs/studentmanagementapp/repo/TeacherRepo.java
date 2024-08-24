package com.lbs.studentmanagementapp.repo;

import com.lbs.studentmanagementapp.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
}
