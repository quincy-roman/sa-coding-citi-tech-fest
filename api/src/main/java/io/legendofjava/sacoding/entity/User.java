package io.legendofjava.sacoding.entity;

import io.legendofjava.sacoding.Enum.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class User {

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
