package io.legendofjava.sacoding.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.legendofjava.sacoding.entity.Assignment;
import io.legendofjava.sacoding.service.LearnerService;

@RestController
@RequestMapping("/api/learner")
public class LearnerController {

    @Autowired
    private LearnerService learnerService;

    @GetMapping("/assignments")
    public ResponseEntity<Collection<Assignment>> getAssignmentsForStudent(@RequestParam String batchId){
        return ResponseEntity.ok(learnerService.getAssignmentsForStudent(batchId));
    }


}
