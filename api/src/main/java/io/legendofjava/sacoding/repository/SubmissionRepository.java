package io.legendofjava.sacoding.repository;

import io.legendofjava.sacoding.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, String> {
    Set<Submission> findAllByUserId(String userId);

}

