package io.legendofjava.sacoding.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import io.legendofjava.sacoding.entity.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, String> {
    Set<Submission> findByUserId(String userId);
}

