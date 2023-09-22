package io.legendofjava.sacoding.service;

import io.legendofjava.sacoding.dto.SubmissionDTO;
import io.legendofjava.sacoding.entity.Assignment;
import io.legendofjava.sacoding.entity.Batch;
import io.legendofjava.sacoding.entity.Submission;
import io.legendofjava.sacoding.repository.UserRepository;

import java.util.Collection;

public interface LearningManagementService {


	//Learner Service Methods
    Collection<Assignment> getAssignmentsForStudent(String batchId);

	Collection<Submission> getSubmissionsForLearner(String userId);

	Submission createSubmission(SubmissionDTO submissionDTO);

	//Facilitator Service Methods
	
	Collection<Submission> getSubmissions(Collection<String> userIds);
	
	Collection<Submission> getSubmissionsForLearner(String userId);

	Collection<Batch> getBatches(String facilitatorId);


	Collection<UserRepository.UserDTO> getLearnersByBatchId(String batchId);

	Submission setGrade(SubmissionDTO submissionDTO);
}