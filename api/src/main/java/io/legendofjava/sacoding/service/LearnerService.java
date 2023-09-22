package io.legendofjava.sacoding.service;

import io.legendofjava.sacoding.entity.Assignment;
import io.legendofjava.sacoding.entity.Batch;
import io.legendofjava.sacoding.repository.AssignmentRepository;
import io.legendofjava.sacoding.repository.BatchRepository;
import io.legendofjava.sacoding.repository.UserRepository;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LearnerService implements LearningManagementService {

    private final UserRepository userRepository;
    private final AssignmentRepository assignmentRepository;
    private final BatchRepository batchRepository;

    private final SubmissionRepository submissionRepository;

    public Collection<Assignment> getAssignmentsForStudent(String batchId){
        return assignmentRepository.findAllByBatchId(batchId);
    }

    public Collection<Batch> getBatches(String facilitatorId) {
        return batchRepository.findByFacilitatorId(facilitatorId);
    }

    public Collection<Submission> getSubmissionsForLearner(String userId) {
        return submissionRepository.findAllByUserId(userId);
    }
}
