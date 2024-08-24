package com.lbs.studentmanagementapp.service;

import com.lbs.studentmanagementapp.dto.CourseDTO;
import com.lbs.studentmanagementapp.dto.CourseSaveDTO;
import com.lbs.studentmanagementapp.dto.CourseUpdateDTO;

import java.util.List;

public interface CourseService {
    String addCourse(CourseSaveDTO courseSaveDTO);

    List<CourseDTO> getAllCourses();

    String updateCourse(CourseUpdateDTO courseUpdateDTO);

    String deleteCourse(int id);
}
