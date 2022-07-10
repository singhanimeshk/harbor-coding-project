package com.calendar.scheduler.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

public class ScheduleData {

    private String id;
    private String userID;
    private Timestamp start;
    private Timestamp end;

    public ScheduleData(String id, String userID, Timestamp start, Timestamp end) {
        this.id = id;
        this.userID = userID;
        this.start = start;
        this.end = end;
    }

    public ScheduleData(String userID, Schedule schedule) {
        this.id = schedule.getId();
        this.userID = userID;
        this.start = new Timestamp(schedule.getStart().getTime());
        this.end = new Timestamp(schedule.getEnd().getTime());
    }

    public ScheduleData() {
        this.id = null;
        this.userID = null;
        this.start = null;
        this.end = null;
    }

    public String getId() {
        return id;
    }

    public String getUserID() {
        return userID;
    }

    public Timestamp getStart() {
        return start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }
}
