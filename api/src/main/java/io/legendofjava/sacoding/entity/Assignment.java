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
    private String id; //@Column(name = "assignment_id")

    @ManyToOne
    @JoinColumn(name="batch_id", nullable=false)
    private Batch batch;

    private String name;
    private Integer maxScore;
    private AssignmentType type;
    private Date dueDate;

    //Assignment
    // Homework, Quiz, Test

}
