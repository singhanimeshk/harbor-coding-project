package com.calendar.scheduler.model;

import java.util.Date;

public class ScheduleRequest {

    private final Date start;
    private final Date end;

    public ScheduleRequest(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "ScheduleRequest{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}
