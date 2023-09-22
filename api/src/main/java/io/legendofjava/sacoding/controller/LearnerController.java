package io.legendofjava.sacoding.controller;

import io.legendofjava.sacoding.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("learner")
public class LearnerController {

    @Autowired
    private LearnerService learnerService;

    @GetMapping("/assignments")
    public ResponseEntity<List<Assignment>> getAssignmentsForStudent(@RequestParam String studentId){
        try{
            List<Assignment> assignmentList= learnerService.getAssignmentsForStudent(studentId);
            return ResponseEntity.ok(assignmentList);
        } catch (Exception e){
            return new ResponseEntity<List<Assignment>>(HttpStatus.BAD_REQUEST);
        }
    }


}
