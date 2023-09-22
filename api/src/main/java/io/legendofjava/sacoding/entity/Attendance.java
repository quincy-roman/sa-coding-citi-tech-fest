package io.legendofjava.sacoding.entity;

import io.legendofjava.sacoding.Enum.AttendanceStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Date;

@Entity
@Data
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
    private String batchId;
    private String userId;
    private Date date;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus attendanceStatus;
}
