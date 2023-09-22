package io.legendofjava.sacoding.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import io.legendofjava.sacoding.entity.Assignment;
import io.legendofjava.sacoding.entity.Batch;
import io.legendofjava.sacoding.entity.Submission;
import io.legendofjava.sacoding.repository.AssignmentRepository;
import io.legendofjava.sacoding.repository.BatchRepository;
import io.legendofjava.sacoding.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LearnerService implements LearningManagementService {
	
    private final UserRepository userRepository;
    private final AssignmentRepository assignmentRepository;
    private final BatchRepository batchRepository;

    public Collection<Assignment> getAssignmentsForStudent(String batchId){
        return assignmentRepository.findAllByBatchId(batchId);
    }

	public Collection<Batch> getBatches(String facilitatorId) {
		return batchRepository.findByFacilitatorId(facilitatorId);
	}

	@Override
	public Collection<Submission> getSubmissions(Collection<String> userIds) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
