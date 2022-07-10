package com.calendar.scheduler.model;

public class ScheduleDeleteRequest {

    private final String userID;
    private final String scheduleID;

    public ScheduleDeleteRequest(String userID, String scheduleID) {
        this.userID = userID;
        this.scheduleID = scheduleID;
    }

    public String getUserID() {
        return userID;
    }

    public String getScheduleID() {
        return scheduleID;
    }
}
