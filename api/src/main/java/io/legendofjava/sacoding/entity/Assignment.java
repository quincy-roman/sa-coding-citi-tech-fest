package io.legendofjava.sacoding.entity;

import io.legendofjava.sacoding.Enum.AssignmentType;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

//This assignment is the facilitator's (teacher's) version of the assignment

@Entity
@Data
public class Assignment {

    @Id
    @GeneratedValue
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
