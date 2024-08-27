package com.lbs.studentmanagementapp.dto;

import com.lbs.studentmanagementapp.entity.Batch;
import com.lbs.studentmanagementapp.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class EnrollmentSaveDTO {
    private int enrollid;
    private int student_id;
    private int batch_id;
    private String batchname;
    private String joindate;
    private int fee;

}
