package com.lbs.studentmanagementapp.controller;

import com.lbs.studentmanagementapp.dto.*;
import com.lbs.studentmanagementapp.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/enrollment")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping(path = "/save")
    public String saveEnrollment(@RequestBody EnrollmentSaveDTO enrollmentSaveDTO) {
        return enrollmentService.addEnrollment(enrollmentSaveDTO);
    }

    @GetMapping("/getAllEnrollments")
    public List<EnrollmentDTO> getAllEnrollments() {
        List<EnrollmentDTO> allEnrollments = enrollmentService.getAllEnrollments();
        return allEnrollments;
    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updateEnrollment(@RequestBody EnrollmentUpdateDTO enrollmentUpdateDTO) {
        try {
            String enrollment = enrollmentService.updateEnrollment(enrollmentUpdateDTO);
            return ResponseEntity.ok("You have been enrolled to " + enrollmentUpdateDTO.getBatch()  + " has been updated.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> deleteEnrollment(@RequestBody DeleteEnrollmentRequest deleteEnrollmentRequest) {
        try {
            String deleteCourse = enrollmentService.deleteEnrollment(deleteEnrollmentRequest.getEnrollmentId);
            return ResponseEntity.ok("Enrollment has been deleted!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}
