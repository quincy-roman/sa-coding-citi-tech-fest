package io.legendofjava.sacoding.repository;

import io.legendofjava.sacoding.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, String> {
    Optional<Assignment> findById(String id);

    List<Assignment> findAllByBatchId(String batchId);

}