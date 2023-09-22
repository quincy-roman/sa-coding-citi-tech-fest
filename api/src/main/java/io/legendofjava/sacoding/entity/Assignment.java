package io.legendofjava.sacoding.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.legendofjava.sacoding.Enum.AssignmentType;
import lombok.Data;


//This assignment is the facilitator's (teacher's) version of the assignment

@Data
@Entity
@Table(name = "ASSIGNMENT")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String batchId;

    private String name;
    private Integer maxScore;

    @Enumerated(EnumType.STRING)
    private AssignmentType type;
    private Date dueDate;

    private String s3FilePath;

    //Assignment
    // Homework, Quiz, Test

}
