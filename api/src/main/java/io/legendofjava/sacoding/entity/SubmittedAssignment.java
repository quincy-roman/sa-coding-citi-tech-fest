package io.legendofjava.sacoding.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

//This assignment is the learner's (Student's) version of the assignment

@Entity
@Data
public class SubmittedAssignment {

    @Id
    @GeneratedValue
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String name;

    private Integer grade;

    private Date submittedDate;


}
