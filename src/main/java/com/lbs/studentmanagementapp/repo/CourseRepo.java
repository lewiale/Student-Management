package com.lbs.studentmanagementapp.repo;

import com.lbs.studentmanagementapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {

}
