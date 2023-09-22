package io.legendofjava.sacoding.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Batch {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private String id;

    private String name;

    private String facilitatorId;
}
