package io.legendofjava.sacoding.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue()
    private String id;

    private String email;

    //private String password;

    private String fName;

    private String lName;

    private String role;

    @ManyToMany
    private Set<Batch> batch;

    private Date attendance;

}
