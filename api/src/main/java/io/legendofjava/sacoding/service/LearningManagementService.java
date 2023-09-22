package io.legendofjava.sacoding.service;

import io.legendofjava.sacoding.entity.Assignment;
import io.legendofjava.sacoding.entity.Batch;
import io.legendofjava.sacoding.entity.Submission;

import java.util.Collection;

public interface LearningManagementService {


	//Learner Service Methods
    Collection<Assignment> getAssignmentsForStudent(String batchId);

	Collection<Submission> getSubmissionsForLearner(String userId);

	//Facilitator Service Methods
	
	Collection<Submission> getSubmissions(Collection<String> userIds);

	Collection<Batch> getBatches(String facilitatorId);



}