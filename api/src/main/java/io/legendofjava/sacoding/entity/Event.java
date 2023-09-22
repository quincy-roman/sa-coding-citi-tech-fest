package io.legendofjava.sacoding.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

//An event is the data entity that will be displayed on the calendar ui.

@Data
@Entity
public class Event {


    @Id
    @GeneratedValue
    private String eventId;

    @OneToOne
    @JoinColumn(name = "assignment_id", nullable = true)
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name="batch_id", nullable=false)
    private Batch batch;

    private String name;
    private String description;
    private Date date;

    //Do we include assignment type here? If the event is an assignment


}
