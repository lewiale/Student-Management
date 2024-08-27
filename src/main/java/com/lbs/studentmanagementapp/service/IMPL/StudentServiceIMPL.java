package com.lbs.studentmanagementapp.service.IMPL;

import com.lbs.studentmanagementapp.dto.StudentDTO;
import com.lbs.studentmanagementapp.dto.StudentSaveDTO;
import com.lbs.studentmanagementapp.dto.StudentUpdateDTO;
import com.lbs.studentmanagementapp.entity.Student;
import com.lbs.studentmanagementapp.repo.StudentRepo;
import com.lbs.studentmanagementapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceIMPL implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public String addStudent(StudentSaveDTO studentSaveDTO) {

        Student student = new Student(
                studentSaveDTO.getStudentname(),
                studentSaveDTO.getAddress(),
                studentSaveDTO.getPhone());

        studentRepo.save(student);

        return student.getStudentname() + " has been added.";
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> getStudents = studentRepo.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        for (Student student : getStudents) {
            StudentDTO myStudent = new StudentDTO();
            myStudent.setStudentid(student.getStudentid());
            myStudent.setAddress(student.getAddress());
            myStudent.setStudentname(student.getStudentname());
            myStudent.setPhone(student.getPhone());
            studentDTOList.add(myStudent);
        }

        return studentDTOList;
    }

    @Override
    public String updateStudent(StudentUpdateDTO studentUpdateDTO) {

        if (studentRepo.existsById(studentUpdateDTO.getStudentid())) {
            Student student = studentRepo.getById(studentUpdateDTO.getStudentid());
            student.setStudentname(studentUpdateDTO.getStudentname());
            student.setAddress(studentUpdateDTO.getAddress());
            student.setPhone(studentUpdateDTO.getPhone());
            studentRepo.save(student);

            return student.getStudentname() + " has been added as a student!";
        } else {
            return "Student ID not found";
        }
    }

    @Override
    public boolean deleteStudent(int id) {

if(studentRepo.existsById(id))
{
    studentRepo.deleteById(id);
}
else
{
    throw new RuntimeException("Student ID " + id + " not found");
}
        return false;
    }
}