package com.lbs.studentmanagementapp.service;

import com.lbs.studentmanagementapp.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BatchService {
    String addBatch(BatchSaveDTO batchSaveDTO);

    List<BatchDTO> getAllBatches();

    String updateBatch(BatchUpdateDTO batchUpdateDTOUpdateDTO);

    String deleteBatch(int batchId);
}
