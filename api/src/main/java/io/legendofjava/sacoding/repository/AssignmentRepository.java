package io.legendofjava.sacoding.repository;

import io.legendofjava.sacoding.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, String> {
    Set<Assignment> findAllByBatchId(String batchId);
}