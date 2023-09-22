package io.legendofjava.sacoding.controller;

import io.legendofjava.sacoding.entity.Assignment;
import io.legendofjava.sacoding.entity.Submission;
import io.legendofjava.sacoding.service.LearnerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/learner")
public class LearnerController {

    private final LearnerService learnerService;

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

}
