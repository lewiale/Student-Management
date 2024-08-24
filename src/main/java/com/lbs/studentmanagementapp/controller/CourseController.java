package com.lbs.studentmanagementapp.controller;

import com.lbs.studentmanagementapp.dto.*;
import com.lbs.studentmanagementapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(path = "/save")
    public String saveCourse(@RequestBody CourseSaveDTO courseSaveDTO) {
        String subject = courseService.addCourse(courseSaveDTO);
        return subject;
    }

    @GetMapping("/getAllCourses")
    public List<CourseDTO> getAllCourses() {
        List<CourseDTO> allCourses = courseService.getAllCourses();
        return courseService.getAllCourses();
    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updateCourse(@RequestBody CourseUpdateDTO courseUpdateDTO) {
        try {
            String updatedSubject = courseService.updateCourse(courseUpdateDTO);
            return ResponseEntity.ok("Course with ID " + courseUpdateDTO.getCourseid() + " (" + courseUpdateDTO.getSubject() + ")" + " has been updated.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> deleteCourse(@RequestBody DeleteCourseRequest deleteCourseRequest) {
        try {
            String deleteCourse = courseService.deleteCourse(deleteCourseRequest.getCourseid());
            return ResponseEntity.ok("Course has been deleted!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
