package io.legendofjava.sacoding.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.legendofjava.sacoding.entity.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, String> {
}

