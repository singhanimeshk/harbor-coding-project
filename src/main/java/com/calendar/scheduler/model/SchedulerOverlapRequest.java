package com.calendar.scheduler.model;

import java.util.List;

public class SchedulerOverlapRequest {

    private final List<String> users;

    public SchedulerOverlapRequest(List<String> users) {
        this.users = users;
    }

    public SchedulerOverlapRequest() {
        this.users = null;
    }
    public List<String> getUsers() {
        return users;
    }
}
