package io.legendofjava.sacoding.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import io.legendofjava.sacoding.entity.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, String> {
    Set<Assignment> findAllByBatchId(String batchId);

}