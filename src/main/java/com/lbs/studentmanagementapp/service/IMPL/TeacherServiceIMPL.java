package com.lbs.studentmanagementapp.service.IMPL;

import com.lbs.studentmanagementapp.dto.TeacherDTO;
import com.lbs.studentmanagementapp.dto.TeacherSaveDTO;
import com.lbs.studentmanagementapp.dto.TeacherUpdateDTO;
import com.lbs.studentmanagementapp.entity.Teacher;
import com.lbs.studentmanagementapp.repo.TeacherRepo;
import com.lbs.studentmanagementapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceIMPL implements TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public String addTeacher(TeacherSaveDTO teacherSaveDTO) {

        Teacher teacher = new Teacher(
                teacherSaveDTO.getTeachername(),
                teacherSaveDTO.getAddress(),
                teacherSaveDTO.getPhone());

        teacherRepo.save(teacher);

        return teacher.getTeachername() + " has been added!";
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {

        List<Teacher> getTeachers = teacherRepo.findAll();
        List<TeacherDTO> TeacherDTOList = new ArrayList<>();
        for (Teacher teacher : getTeachers) {
            TeacherDTO myTeacher = new TeacherDTO();
            myTeacher.setTeacherid(teacher.getTeacherid());
            myTeacher.setAddress(teacher.getAddress());
            myTeacher.setTeachername(teacher.getTeachername());
            myTeacher.setPhone(teacher.getPhone());
            TeacherDTOList.add(myTeacher);
        }

        return TeacherDTOList;

    }

    @Override
    public String updateTeacher(TeacherUpdateDTO teacherUpdateDTO) {
        if (teacherRepo.existsById(teacherUpdateDTO.getTeacherid())) {
            Teacher teacher = teacherRepo.getById(teacherUpdateDTO.getTeacherid());
            teacher.setTeachername(teacherUpdateDTO.getTeachername());
            teacher.setAddress(teacherUpdateDTO.getAddress());
            teacher.setPhone(teacherUpdateDTO.getPhone());
            teacherRepo.save(teacher);
            return teacher.getTeachername() + " has been updated as a teacher!";
        }
        else

    {
        System.out.println("Teacher ID Not Found");

    }
    return null;
}

    @Override
    public String deleteTeacher(int id) {
        Teacher teacher = teacherRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher ID " + id + " not found" + " teacher might have already been deleted."));
        teacherRepo.deleteById(id);
        return teacher.getTeachername();
    }
}
