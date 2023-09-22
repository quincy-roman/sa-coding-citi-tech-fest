package io.legendofjava.sacoding.service;

import io.legendofjava.sacoding.dto.SubmissionDTO;
import io.legendofjava.sacoding.entity.Assignment;
import io.legendofjava.sacoding.entity.Batch;
import io.legendofjava.sacoding.entity.Submission;
import io.legendofjava.sacoding.repository.AssignmentRepository;
import io.legendofjava.sacoding.repository.BatchRepository;
import io.legendofjava.sacoding.repository.SubmissionRepository;
import io.legendofjava.sacoding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class LearnerService implements LearningManagementService {

    private final AssignmentRepository assignmentRepository;
    private final BatchRepository batchRepository;
    private final SubmissionRepository submissionRepository;
    private final UserRepository userRepository;


    //Learners:
    public Collection<Assignment> getAssignmentsForStudent(String batchId){
        return assignmentRepository.findAllByBatchId(batchId);
    }

    public Collection<Submission> getSubmissionsForLearner(String userId) {
        return submissionRepository.findByUserId(userId);
    }

    public Submission createSubmission(SubmissionDTO submissionDTO){

        Submission submission = new Submission(submissionDTO.getId(), submissionDTO.getUserId(), submissionDTO.getAssignmentId(),
                submissionDTO.getS3FilePath(), submissionDTO.getGrade(), submissionDTO.getSubmittedDate());

        return submissionRepository.save(submission);
    }


    //Facilitators:
    public Collection<Batch> getBatches(String facilitatorId) {
        return batchRepository.findByFacilitatorId(facilitatorId);
    }

    @Override
    public Collection<Submission> getSubmissions(Collection<String> userIds) {
        return null;
    }

    public Collection<UserRepository.UserDTO> getLearnersByBatchId(String batchId){
        return userRepository.findByBatchId(batchId);
    }

    public Submission setGrade(SubmissionDTO submissionDTO){

        Optional<Submission> submissionOptional = submissionRepository.findById(submissionDTO.getId());

        Submission submission = new Submission();

        if (submissionOptional.isPresent()){
            submission = submissionOptional.get();

            submission.setGrade(submissionDTO.getGrade());

            return submissionRepository.save(submission);
        }
        else{
            log.error("No submission found with that id");
            throw new RuntimeException("No submission found with id: " + submission.getId());
        }


    }


}
