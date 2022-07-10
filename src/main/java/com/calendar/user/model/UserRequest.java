package com.calendar.user.model;

public class UserRequest {

    private final String name;

    public UserRequest(String name) {
        this.name = name;
    }

    public UserRequest() {
        this.name = "";
    }

    public String getName() {
        return name;
    }
}
