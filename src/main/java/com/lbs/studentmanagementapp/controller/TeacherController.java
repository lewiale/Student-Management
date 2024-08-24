package com.lbs.studentmanagementapp.controller;

import com.lbs.studentmanagementapp.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.lbs.studentmanagementapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("api/v1/teacher")

public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping(path = "/save" )
    public String saveTeacher(@RequestBody TeacherSaveDTO teacherSaveDTO)
    {
        String teachername = teacherService.addTeacher(teacherSaveDTO);
        return teachername;
    }

    @GetMapping("/getAllTeachers")
    public List<TeacherDTO> getAllTeachers()
    {
        List<TeacherDTO> allTeachers = teacherService.getAllTeachers();
        return allTeachers;
    }
    @PutMapping (path = "/update" )
    public String updateTeacher(@RequestBody TeacherUpdateDTO teacherUpdateDTO)
    {
        String teachername = teacherService.updateTeacher(teacherUpdateDTO);
        return teachername;
    }
    @PostMapping(path = "/delete")
    public ResponseEntity<String> deleteTeacher(@RequestBody DeleteTeacherRequest deleteTeacherRequest) {
        try {
            String teacherName = teacherService.deleteTeacher(deleteTeacherRequest.getTeacherid());
            return ResponseEntity.ok("Teacher with ID " + deleteTeacherRequest.getTeacherid() + " (" + teacherName + ") has been deleted!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}

