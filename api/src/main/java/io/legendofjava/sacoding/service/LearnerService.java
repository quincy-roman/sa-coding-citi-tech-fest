package io.legendofjava.sacoding.service;

import io.legendofjava.sacoding.entity.Assignment;
import io.legendofjava.sacoding.entity.Batch;
import io.legendofjava.sacoding.entity.Submission;
import io.legendofjava.sacoding.repository.AssignmentRepository;
import io.legendofjava.sacoding.repository.BatchRepository;
import io.legendofjava.sacoding.repository.SubmissionRepository;
import io.legendofjava.sacoding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class LearnerService implements LearningManagementService {

    private final AssignmentRepository assignmentRepository;
    private final BatchRepository batchRepository;
    private final SubmissionRepository submissionRepository;
    private final UserRepository userRepository;


    //Learners:
    public Collection<Assignment> getAssignmentsForStudent(String batchId){
        return assignmentRepository.findAllByBatchId(batchId);
    }

    public Collection<Submission> getSubmissionsForLearner(String userId) {
        return submissionRepository.findByUserId(userId);
    }


    //Facilitators:
    public Collection<Batch> getBatches(String facilitatorId) {
        return batchRepository.findByFacilitatorId(facilitatorId);
    }

    @Override
    public Collection<Submission> getSubmissions(Collection<String> userIds) {
        return null;
    }

    public Collection<UserRepository.UserDTO> getLearnersByBatchId(String batchId){
        return userRepository.findByBatchId(batchId);
    }


}
