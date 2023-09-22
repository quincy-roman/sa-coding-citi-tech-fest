package io.legendofjava.sacoding.controller;

import io.legendofjava.sacoding.entity.Assignment;
import io.legendofjava.sacoding.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/learner")
public class LearnerController {

    @Autowired
    private LearnerService learnerService;

    @GetMapping("/assignments")
    public ResponseEntity<List<Assignment>> getAssignmentsForStudent(@RequestParam String batchId){
        List<Assignment> assignmentList= learnerService.getAssignmentsForStudent(batchId);
        return ResponseEntity.ok(assignmentList);
    }


}
