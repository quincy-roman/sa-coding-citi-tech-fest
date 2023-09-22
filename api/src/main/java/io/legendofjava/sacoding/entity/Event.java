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

    private String assignmentId;
    private String batchId;

    private String name;
    private String description;
    private Date date;

    //Do we include assignment type here? If the event is an assignment


}
