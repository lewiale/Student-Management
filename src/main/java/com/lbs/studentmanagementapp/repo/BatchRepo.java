package com.lbs.studentmanagementapp.repo;

import com.lbs.studentmanagementapp.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepo extends JpaRepository<Batch,Integer> {
}
