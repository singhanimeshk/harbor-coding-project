package com.calendar.scheduler.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Schedule {

    private String id;
    private Date start;
    private Date end;

    public Schedule(String id, Date start, Date end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public Schedule(ScheduleRequest scheduleRequest) {
        this.id = UUID.randomUUID().toString();
        this.start = scheduleRequest.getStart();
        this.end = scheduleRequest.getEnd();
    }

    public Schedule(ScheduleData scheduleData) {
        this.id = scheduleData.getId();
        this.start = new Date(scheduleData.getStart().getTime());
        this.end = new Date(scheduleData.getEnd().getTime());
    }

    public String getId() {
        return id;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
