package io.legendofjava.sacoding.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

//An event is the data entity that will be displayed on the calendar ui.

@Data
@Entity
@Table(name = "EVENT")
public class Event {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String eventId;

    private String batchId;

    private String name;
    private String description;
    private Date date;

    //Do we include assignment type here? If the event is an assignment


}
