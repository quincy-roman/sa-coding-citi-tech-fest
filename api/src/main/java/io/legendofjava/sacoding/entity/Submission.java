package io.legendofjava.sacoding.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

//This assignment is the learner's (Student's) version of the assignment

@Entity
@Data
public class Submission {

    @Id
    @GeneratedValue
    private String id;

    private String userId;

    private String assignmentId;

    private String s3FilePath;

    private Integer grade;

    private Date submittedDate;


}
