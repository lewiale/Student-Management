package com.lbs.studentmanagementapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherUpdateDTO {
    private int teacherid;
    private String teachername;
    private String address;
    private String phone;
}


