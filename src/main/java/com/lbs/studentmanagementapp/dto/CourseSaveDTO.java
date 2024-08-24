package com.lbs.studentmanagementapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CourseSaveDTO {

    private String subject;


    private String syllabus;


    private Integer duration;
}
