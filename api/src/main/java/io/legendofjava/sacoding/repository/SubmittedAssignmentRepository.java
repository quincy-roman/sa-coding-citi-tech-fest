package io.legendofjava.sacoding.repository;

import io.legendofjava.sacoding.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubmittedAssignmentRepository extends JpaRepository<Submission, String> {
    Optional<Submission> findById(String id);

}

