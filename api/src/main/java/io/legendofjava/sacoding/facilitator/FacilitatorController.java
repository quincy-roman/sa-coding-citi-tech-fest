package io.legendofjava.sacoding.facilitator;

import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.legendofjava.sacoding.entity.Batch;
import io.legendofjava.sacoding.service.LearningManagementService;
import lombok.RequiredArgsConstructor;

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

}
