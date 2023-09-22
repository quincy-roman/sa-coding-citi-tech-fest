package io.legendofjava.sacoding.facilitator;

import io.legendofjava.sacoding.entity.Batch;
import io.legendofjava.sacoding.repository.UserRepository;
import io.legendofjava.sacoding.service.LearningManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/facilitator")
@RequiredArgsConstructor
public class FacilitatorController {
	
	private final LearningManagementService service;
	
	@GetMapping("/batches")
	public ResponseEntity<Collection<Batch>> getBatches(@RequestParam String facilitatorId) {
		return ResponseEntity.ok(service.getBatches(facilitatorId));
	}
	
	@GetMapping("/grades")
	public ResponseEntity<Object> getGrades(@RequestParam List<String> userIds) {
		return ResponseEntity.ok(service.getSubmissions(userIds));
	}

	@GetMapping("/learnersInBatch")
	public ResponseEntity<Collection<UserRepository.UserDTO>> getLearners(@RequestParam String batchId){
		return ResponseEntity.ok(service.getLearnersByBatchId(batchId));
	}

}
