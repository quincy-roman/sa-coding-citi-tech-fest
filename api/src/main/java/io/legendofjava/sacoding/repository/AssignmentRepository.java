package io.legendofjava.sacoding.repository;

import io.legendofjava.sacoding.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AssignmentRepository extends JpaRepository<Assignment, String> {
    Set<Assignment> findAllByBatchId(String batchId);

}