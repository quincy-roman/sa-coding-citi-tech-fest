package io.legendofjava.sacoding.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class SubmissionDTO {

    private String id;

    private String userId;

    private String assignmentId;

    private String s3FilePath;

    //For the frontend, will only allow learner to send dto with grade at 0 initially
    private Integer grade;

    private Date submittedDate;


}
