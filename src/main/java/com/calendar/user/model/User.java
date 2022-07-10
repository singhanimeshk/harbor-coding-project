package com.calendar.user.model;

import java.util.UUID;

public class User {

    private final String id;
    private final String name;

    public User(String userID, String name) {
        this.id = userID;
        this.name = name;
    }

    public User(UserRequest userRequest) {
        this.id = UUID.randomUUID().toString();
        this.name = userRequest.getName();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
