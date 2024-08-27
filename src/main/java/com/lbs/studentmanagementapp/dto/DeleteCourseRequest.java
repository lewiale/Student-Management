package com.lbs.studentmanagementapp.dto;

public class DeleteCourseRequest {
    private Integer courseid;  // Ensure this is exactly how it’s spelled

    public DeleteCourseRequest() {
    }

    public DeleteCourseRequest(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
    }

    public int getBatchId() {
        return getBatchId();
    }
}

