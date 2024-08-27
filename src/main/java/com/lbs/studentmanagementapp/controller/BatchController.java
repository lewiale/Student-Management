package com.lbs.studentmanagementapp.controller;

import com.lbs.studentmanagementapp.dto.*;
import com.lbs.studentmanagementapp.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/batch")
public class BatchController {

    @Autowired
    private BatchService batchService;

    @PostMapping(path = "/save")
    public String saveBatch(@RequestBody BatchSaveDTO batchSaveDTO) {
        String batch = batchService.addBatch(batchSaveDTO);
        return batch;
    }

    @GetMapping("/getAllBatches")
    public List<BatchDTO> getAllBatches() {
        List<BatchDTO> allBatches = batchService.getAllBatches();
        return allBatches;
    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updateBatch(@RequestBody BatchUpdateDTO batchUpdateDTO) {
        try {
            String updatedBatch = batchService.updateBatch(batchUpdateDTO);
            return ResponseEntity.ok("Batch with ID " + batchUpdateDTO.getCourseid() + " (" + batchUpdateDTO.getBatchname() + ")" + " has been updated.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> deleteBatch(@RequestBody DeleteBatchRequest deleteBatchRequest) {
        try {
            String result = batchService.deleteBatch(deleteBatchRequest.getBatchId());
            return ResponseEntity.ok(result);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
