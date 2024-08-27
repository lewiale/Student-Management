package com.lbs.studentmanagementapp.service;

import com.lbs.studentmanagementapp.dto.EnrollmentDTO;
import com.lbs.studentmanagementapp.dto.EnrollmentSaveDTO;
import com.lbs.studentmanagementapp.dto.EnrollmentUpdateDTO;

import java.util.List;

public interface EnrollmentService {
    String addEnrollment(EnrollmentSaveDTO enrollmentSaveDTO);

    List<EnrollmentDTO> getAllEnrollments();

    String updateEnrollment(EnrollmentUpdateDTO enrollmentUpdateDTO);

    String deleteEnrollment(Integer getEnrollmentId);

}
