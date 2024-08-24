package com.lbs.studentmanagementapp.repo;

import com.lbs.studentmanagementapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
