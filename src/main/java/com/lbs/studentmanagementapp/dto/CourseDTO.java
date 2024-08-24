package com.lbs.studentmanagementapp.dto;

import com.lbs.studentmanagementapp.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDTO {

    private int courseid;


    private String subject;


    private String syllabus;


    private Integer duration;

    public void setBatchname(String batchname) {
    }

    public void setBatchid(int batchid) {
    }

    public void setGetCourse(Course course) {
    }

    public void setStartDate(String startdate) {
    }
}
