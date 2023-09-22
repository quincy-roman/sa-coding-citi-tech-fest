package io.legendofjava.sacoding.facilitator;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import io.legendofjava.sacoding.s3.S3Service;
import io.legendofjava.sacoding.dto.SubmissionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.legendofjava.sacoding.entity.Batch;
import io.legendofjava.sacoding.entity.Submission;
import io.legendofjava.sacoding.repository.UserRepository;
import io.legendofjava.sacoding.service.LearningManagementService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/facilitator")
@RequiredArgsConstructor
public class FacilitatorController {
	
	private final LearningManagementService service;

	private final S3Service s3Service;

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

	@PutMapping("/grades")
	public ResponseEntity<Submission> setGrade(@RequestBody SubmissionDTO submissionDTO){
		return ResponseEntity.ok(service.setGrade(submissionDTO));
	}

	@GetMapping("/getFileFromS3")
	public ResponseEntity<String> getFileFromS3(@RequestParam String fileName) throws IOException {
		s3Service.downloadFileFromS3(fileName);
		return ResponseEntity.ok(fileName);
	}

	@PostMapping("uploadFileToS3")
	public ResponseEntity<String> uploadFileToS3 (@RequestParam String fileName){
		s3Service.uploadFileToS3(fileName);
		return ResponseEntity.ok(fileName);
	}

}
