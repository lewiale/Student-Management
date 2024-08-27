package com.lbs.studentmanagementapp.dto;

public class DeleteEnrollmentRequest {
    public Integer getEnrollmentId;
    public DeleteEnrollmentRequest() {
    }

    public DeleteEnrollmentRequest(Integer getEnrollmentId) {
        this.getEnrollmentId = getEnrollmentId;
    }

    public Integer getEnrollmentId() {
        return getEnrollmentId;
    }

    public void setEnrollmentId(Integer EnrollmentId) {
        this.getEnrollmentId = EnrollmentId;
    }
}
