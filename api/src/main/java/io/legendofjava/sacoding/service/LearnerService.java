package io.legendofjava.sacoding.service;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class LearnerService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private BatchRepository batchRepository;

    public List<Assignment> getAssignments(String studentId) throws Exception{
//        List<String> batchIdList = batchRepository.findAllByUserId(studentId).stream().
//                map(batch -> batch.getBatchId()).collect(Collectors.toList());
        List<String> batchIdList = batchRepository.findAllBatchIdByUserId(studentId);
        return assignmentRepository.findByBatchId(batchIdList);
    }
}
