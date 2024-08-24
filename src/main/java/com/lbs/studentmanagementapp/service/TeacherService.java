package com.lbs.studentmanagementapp.service;

import com.lbs.studentmanagementapp.dto.TeacherDTO;
import com.lbs.studentmanagementapp.dto.TeacherSaveDTO;
import com.lbs.studentmanagementapp.dto.TeacherUpdateDTO;

import java.util.List;

public interface TeacherService {
    String addTeacher(TeacherSaveDTO teacherSaveDTO);

    List<TeacherDTO> getAllTeachers();

    String updateTeacher(TeacherUpdateDTO teacherUpdateDTO);

    String deleteTeacher(int id);
}
