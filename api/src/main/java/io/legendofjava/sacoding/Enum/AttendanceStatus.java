package io.legendofjava.sacoding.Enum;

public enum AttendanceStatus {
    PRESENT("Present"), LATE("Late"), ABSENT("Absent");

    public final String status;

    private AttendanceStatus(String status) {
        this.status =  status;
    }
}
