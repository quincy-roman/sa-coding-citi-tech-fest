package io.legendofjava.sacoding.controller;

import io.legendofjava.sacoding.dto.SubmissionDTO;
import io.legendofjava.sacoding.entity.Assignment;
import io.legendofjava.sacoding.entity.Submission;
import io.legendofjava.sacoding.s3.S3Service;
import io.legendofjava.sacoding.service.LearnerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.Collection;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/learner")
public class LearnerController {

    private final LearnerService learnerService;
    private final S3Service s3Service;

    @GetMapping("/assignments")
    public ResponseEntity<Collection<Assignment>> getAssignmentsForStudent(@RequestParam String batchId){
        Collection<Assignment> assignmentList= learnerService.getAssignmentsForStudent(batchId);
        return ResponseEntity.ok(assignmentList);
    }

    @GetMapping("/submissions")
    public ResponseEntity<Collection<Submission>> getSubmissionsForStudent(@RequestParam String userId){
        log.info("Finding submissions for learner id: " + userId);
        Collection<Submission> submissionList= learnerService.getSubmissionsForLearner(userId);
        return ResponseEntity.ok(submissionList);
    }

    @PostMapping("/submissions")
    public ResponseEntity<Submission> createSubmission(@RequestBody SubmissionDTO submissionDTO){
        return ResponseEntity.ok(learnerService.createSubmission(submissionDTO));
    }

    @GetMapping("/getFileFromS3")
    public ResponseEntity<String> getFileFromS3(@RequestParam String fileName) throws IOException {
        s3Service.downloadFileFromS3(fileName);
        return ResponseEntity.ok(fileName);
    }

    @PostMapping("uploadFileToS3")
    public ResponseEntity<String> uploadFileToS3(@RequestParam String fileName){
        s3Service.uploadFileToS3(fileName);
        return ResponseEntity.ok(fileName);
    }

}
