package com.lbs.studentmanagementapp.service;

import com.lbs.studentmanagementapp.dto.StudentDTO;
import com.lbs.studentmanagementapp.dto.StudentSaveDTO;
import com.lbs.studentmanagementapp.dto.StudentUpdateDTO;

import java.util.List;

public interface StudentService {
    String addStudent(StudentSaveDTO studentSaveDTO);

    List<StudentDTO> getAllStudents();

    String updateStudent(StudentUpdateDTO studentUpdateDTO);

    boolean deleteStudent(int id);
}

