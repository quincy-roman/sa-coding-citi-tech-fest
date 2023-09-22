package io.legendofjava.sacoding.service;

import io.legendofjava.sacoding.entity.Assignment;
import io.legendofjava.sacoding.entity.Submission;
import io.legendofjava.sacoding.repository.AssignmentRepository;
import io.legendofjava.sacoding.repository.SubmissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@AllArgsConstructor
@Service
public class LearnerService {

    private final AssignmentRepository assignmentRepository;

    private final SubmissionRepository submissionRepository;

    public Collection<Assignment> getAssignmentsForStudent(String batchId){
        return assignmentRepository.findAllByBatchId(batchId);
    }

    public Collection<Submission> getSubmissionsForLearner(String userId) {
        return submissionRepository.findAllByUserId(userId);
    }
}
