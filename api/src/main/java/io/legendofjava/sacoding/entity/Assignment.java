package io.legendofjava.sacoding.entity;

import java.sql.Date;

import javax.persistence.*;

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

    @Column(name="assignment_Type")
    @Enumerated(EnumType.STRING)
    private AssignmentType type;

    private Date dueDate;

    @Column(name="s3_File_Path")
    private String s3FilePath;

    //Assignment
    // Homework, Quiz, Test

}
