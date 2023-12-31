package io.legendofjava.sacoding.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


//This assignment is the learner's (Student's) version of the assignment

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SUBMISSION")
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String userId;

    private String assignmentId;

    private String s3FilePath;

    private Integer grade;

    @UpdateTimestamp
    private Date submittedDate;


}
