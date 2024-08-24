package com.lbs.studentmanagementapp.controller;

import com.lbs.studentmanagementapp.dto.BatchDTO;
import com.lbs.studentmanagementapp.dto.BatchSaveDTO;
import com.lbs.studentmanagementapp.dto.CourseDTO;
import com.lbs.studentmanagementapp.dto.CourseSaveDTO;
import com.lbs.studentmanagementapp.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<BatchDTO> getAllCourses() {
        List<BatchDTO> allBatches = batchService.getAllBatches();
        return allBatches;
    }

}
