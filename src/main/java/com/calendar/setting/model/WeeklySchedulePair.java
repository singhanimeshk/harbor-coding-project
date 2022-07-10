package com.calendar.setting.model;

public class WeeklySchedulePair {

    private String start;
    private String end;

    public WeeklySchedulePair(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public WeeklySchedulePair() {}

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
