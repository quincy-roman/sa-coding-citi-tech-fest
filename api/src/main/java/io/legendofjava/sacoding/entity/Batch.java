package io.legendofjava.sacoding.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;


//In South Africa they call a class in a school a batch
@Entity
@Data
public class Batch {

    @Id
    @GeneratedValue
    @Column(name = "batch_id", nullable = false)
    private String id;

    private String name;

    @ManyToMany(mappedBy = "batch")
    private Set<User> user;


    @OneToMany
    private Set<Assignment> assignments;

    @OneToMany
    private Set<Event> events;
}
