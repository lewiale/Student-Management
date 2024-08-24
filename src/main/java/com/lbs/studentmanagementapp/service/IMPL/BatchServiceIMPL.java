package com.lbs.studentmanagementapp.service.IMPL;

import com.lbs.studentmanagementapp.dto.BatchDTO;
import com.lbs.studentmanagementapp.dto.BatchSaveDTO;
import com.lbs.studentmanagementapp.dto.CourseDTO;
import com.lbs.studentmanagementapp.entity.Batch;
import com.lbs.studentmanagementapp.entity.Course;
import com.lbs.studentmanagementapp.repo.BatchRepo;
import com.lbs.studentmanagementapp.repo.CourseRepo;
import com.lbs.studentmanagementapp.service.BatchService;
import com.lbs.studentmanagementapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BatchServiceIMPL implements BatchService {

    @Autowired
    private BatchRepo batchRepo;
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public String addBatch(BatchSaveDTO batchSaveDTO) {

        Batch batch = new Batch(
                batchSaveDTO.getBatchname(),
                batchSaveDTO.getStartdate(),
                courseRepo.getById(batchSaveDTO.getCourseid()));

        batchRepo.save(batch);
        return batch.getBatchname() + " has been added to your list of Batches.";
    }

    @Override
    public List<BatchDTO> getAllBatches() {
        List<Batch> getBatches = batchRepo.findAll();
        List<BatchDTO> batchDTOList = new ArrayList<>();

        for (Batch batch : getBatches) {
            BatchDTO myBatch = new BatchDTO();
            myBatch.setBatchid(batch.getBatchid());
            myBatch.setBatchname(batch.getBatchname());
            myBatch.setCourse(batch.getCourse());
            myBatch.setStartdate(batch.getStartdate());
            batchDTOList.add(myBatch);
        }

        return batchDTOList;
    }


}
