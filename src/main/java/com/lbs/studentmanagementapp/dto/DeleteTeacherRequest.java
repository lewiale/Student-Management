package com.lbs.studentmanagementapp.dto;

public class DeleteTeacherRequest {
    private Integer teacherid;

    public DeleteTeacherRequest() {
    }

    public DeleteTeacherRequest(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }
}
