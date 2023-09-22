package io.legendofjava.sacoding.service;

import io.legendofjava.sacoding.entity.Assignment;
import io.legendofjava.sacoding.entity.Batch;
import io.legendofjava.sacoding.entity.Submission;
import io.legendofjava.sacoding.repository.AssignmentRepository;
import io.legendofjava.sacoding.repository.BatchRepository;
import io.legendofjava.sacoding.repository.SubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class LearnerService implements LearningManagementService {

    private final AssignmentRepository assignmentRepository;
    private final BatchRepository batchRepository;

    private final SubmissionRepository submissionRepository;

    public Collection<Assignment> getAssignmentsForStudent(String batchId){
        return assignmentRepository.findAllByBatchId(batchId);
    }

    public Collection<Batch> getBatches(String facilitatorId) {
        return batchRepository.findByFacilitatorId(facilitatorId);
    }

    @Override
    public Collection<Submission> getSubmissions(Collection<String> userIds) {
        return null;
    }

    public Collection<Submission> getSubmissionsForLearner(String userId) {
        return submissionRepository.findAllByUserId(userId);
    }
}
