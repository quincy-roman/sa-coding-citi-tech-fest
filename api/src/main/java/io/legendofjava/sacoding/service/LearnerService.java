package io.legendofjava.sacoding.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import io.legendofjava.sacoding.entity.Assignment;
import io.legendofjava.sacoding.entity.Batch;
import io.legendofjava.sacoding.entity.Submission;
import io.legendofjava.sacoding.repository.AssignmentRepository;
import io.legendofjava.sacoding.repository.BatchRepository;
import io.legendofjava.sacoding.repository.SubmissionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LearnerService implements LearningManagementService {

    private final AssignmentRepository assignmentRepository;
    private final BatchRepository batchRepository;

    private final SubmissionRepository submissionRepository;

    @Override
    public Collection<Assignment> getAssignmentsForStudent(String batchId){
        return assignmentRepository.findAllByBatchId(batchId);
    }

    @Override
    public Collection<Batch> getBatches(String facilitatorId) {
        return batchRepository.findByFacilitatorId(facilitatorId);
    }

    @Override
    public Collection<Submission> getSubmissions(Collection<String> userIds) {
        return submissionRepository.findAllById(userIds);
    }

    @Override
    public Collection<Submission> getSubmissionsForLearner(String userId) {
        return submissionRepository.findByUserId(userId);
    }


}
