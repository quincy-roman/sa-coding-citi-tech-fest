package io.legendofjava.sacoding.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

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
