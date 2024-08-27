package com.lbs.studentmanagementapp.service.IMPL;
import com.lbs.studentmanagementapp.entity.Student;
import com.lbs.studentmanagementapp.dto.EnrollmentDTO;
import com.lbs.studentmanagementapp.dto.EnrollmentSaveDTO;
import com.lbs.studentmanagementapp.dto.EnrollmentUpdateDTO;
import com.lbs.studentmanagementapp.entity.Batch;
import com.lbs.studentmanagementapp.entity.Enrollment;
import com.lbs.studentmanagementapp.repo.BatchRepo;
import com.lbs.studentmanagementapp.repo.EnrollmentRepo;
import com.lbs.studentmanagementapp.repo.StudentRepo;
import com.lbs.studentmanagementapp.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentServiceIMPL implements EnrollmentService {

    @Autowired
    private EnrollmentRepo enrollmentRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private BatchRepo batchRepo;

    @Override
    public String addEnrollment(EnrollmentSaveDTO enrollmentSaveDTO) {
        Student student = studentRepo.getById(enrollmentSaveDTO.getStudent_id());
        Batch batch = batchRepo.getById(enrollmentSaveDTO.getBatch_id());
        Enrollment enrollment = new Enrollment(
                student,
                batch,
                batch.getBatchname(),
                enrollmentSaveDTO.getJoindate(),
                enrollmentSaveDTO.getFee()
        );
        enrollmentRepo.save(enrollment);

        return "You have been enrolled into " + enrollment.getBatchname() + ".";
    }



    @Override
    public List<EnrollmentDTO> getAllEnrollments() {

        List<Enrollment> getEnrollment = enrollmentRepo.findAll();
        List<EnrollmentDTO> enrollmentDTOList = new ArrayList<>();

        for (Enrollment enrollment : getEnrollment) {
            EnrollmentDTO myEnrollment = new EnrollmentDTO();
            myEnrollment.setEnrollid(enrollment.getEnrollid());
            myEnrollment.setStudent(enrollment.getStudent());
            myEnrollment.setJoindate(enrollment.getJoindate());
            myEnrollment.setFee(enrollment.getFee());
            enrollmentDTOList.add(myEnrollment);
        }

        return enrollmentDTOList;
    }

    @Override
    public String updateEnrollment(EnrollmentUpdateDTO enrollmentUpdateDTO) {
    if(enrollmentRepo.existsById(enrollmentUpdateDTO.getEnrollid()))
    {
        Enrollment enrollment = enrollmentRepo.getById(enrollmentUpdateDTO.getEnrollid());
        Student st = studentRepo.getById(enrollmentUpdateDTO.getStudent().getStudentid());
        enrollment.setStudent(studentRepo.getById(enrollmentUpdateDTO.getStudent().getStudentid()));
        enrollment.setBatch(batchRepo.getReferenceById(enrollmentUpdateDTO.getBatch().getBatchid()));
        enrollment.setJoindate(enrollmentUpdateDTO.getJoindate());
        enrollment.setFee(enrollmentUpdateDTO.getFee());

        enrollmentRepo.save(enrollment);
        return enrollment.getJoindate();
    }
    else
    {
        System.out.println("Enrollment ID Not Found");
    }
    return null;
    }

    @Override
    public String deleteEnrollment(Integer getEnrollmentId) {
        if (enrollmentRepo.existsById(getEnrollmentId)) {
            enrollmentRepo.deleteById(getEnrollmentId);
            return "Enrollment with ID " + getEnrollmentId + " has been deleted.";
        } else {
            throw new RuntimeException("Enrollment ID not found");
        }
    }
    }