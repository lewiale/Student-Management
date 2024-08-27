package com.lbs.studentmanagementapp.repo;

import com.lbs.studentmanagementapp.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepo extends JpaRepository<Enrollment, Integer> {
}
