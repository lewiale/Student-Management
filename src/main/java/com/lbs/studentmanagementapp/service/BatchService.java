package com.lbs.studentmanagementapp.service;

import com.lbs.studentmanagementapp.dto.BatchDTO;
import com.lbs.studentmanagementapp.dto.BatchSaveDTO;
import com.lbs.studentmanagementapp.dto.CourseDTO;

import java.util.List;

public interface BatchService {
    String addBatch(BatchSaveDTO batchSaveDTO);

    List<BatchDTO> getAllBatches();
}
