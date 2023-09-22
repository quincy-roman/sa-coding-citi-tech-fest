package io.legendofjava.sacoding.repository;

import io.legendofjava.sacoding.entity.SubmittedAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubmittedAssignmentRepository extends JpaRepository<SubmittedAssignment, String> {
    Optional<SubmittedAssignment> findById(String id);

}

