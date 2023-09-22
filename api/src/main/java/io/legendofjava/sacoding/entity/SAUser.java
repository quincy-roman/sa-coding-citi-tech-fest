package io.legendofjava.sacoding.entity;

import io.legendofjava.sacoding.Enum.Role;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SAUser {

    @Id
    @GeneratedValue()
    private String id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "BATCH_ID", nullable = true) // only learners have a batch id
    private String batchId;


}
