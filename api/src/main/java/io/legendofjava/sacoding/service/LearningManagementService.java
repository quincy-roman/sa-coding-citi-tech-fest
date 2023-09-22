package io.legendofjava.sacoding.service;

import java.util.Collection;

import io.legendofjava.sacoding.entity.Assignment;
import io.legendofjava.sacoding.entity.Batch;
import io.legendofjava.sacoding.entity.Submission;

public interface LearningManagementService {
	
    Collection<Assignment> getAssignmentsForStudent(String batchId);

	Collection<Batch> getBatches(String facilitatorId);
	
	Collection<Submission> getSubmissions(Collection<String> userIds);

}