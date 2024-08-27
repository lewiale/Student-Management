package com.lbs.studentmanagementapp.service.IMPL;

import com.lbs.studentmanagementapp.dto.CourseDTO;
import com.lbs.studentmanagementapp.dto.CourseSaveDTO;
import com.lbs.studentmanagementapp.dto.CourseUpdateDTO;
import com.lbs.studentmanagementapp.entity.Course;
import com.lbs.studentmanagementapp.repo.CourseRepo;
import com.lbs.studentmanagementapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceIMPL implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public String addCourse(CourseSaveDTO courseSaveDTO) {
        Course course = new Course(
                courseSaveDTO.getSubject(),
                courseSaveDTO.getSyllabus(),
                courseSaveDTO.getDuration());

        courseRepo.save(course);
        return course.getSubject() + " has been added to your list of courses.";
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        List<Course> getCourses = courseRepo.findAll();
        List<CourseDTO> courseDTOList = new ArrayList<>();

        for (Course course : getCourses) {
            CourseDTO myCourse = new CourseDTO();
            myCourse.setCourseid(course.getCourseid());
            myCourse.setSubject(course.getSubject());
            myCourse.setSyllabus(course.getSyllabus());
            myCourse.setDuration(course.getDuration());
            courseDTOList.add(myCourse);
        }

        return courseDTOList;
    }

    @Override
    public String updateCourse(CourseUpdateDTO courseUpdateDTO) {
        if (courseRepo.existsById(courseUpdateDTO.getCourseid())) {
            Course course = courseRepo.getById(courseUpdateDTO.getCourseid());
            course.setSubject(courseUpdateDTO.getSubject());
            course.setDuration(courseUpdateDTO.getDuration());
            course.setSyllabus(courseUpdateDTO.getSyllabus());
            courseRepo.save(course);
            return "Course with ID " + courseUpdateDTO.getCourseid() + " (" + course.getSubject() + ") has been updated.";
        } else {
            return "Course ID not found";
        }
    }


    @Override
    public String deleteCourse(int id) {
        if(courseRepo.existsById(id)) {
            courseRepo.deleteById(id);
            return "Course with ID " + id + " has been deleted!";
        } else {
            throw new RuntimeException("Course ID " + id + " not found");
        }
    }
}


