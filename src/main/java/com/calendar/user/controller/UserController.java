package com.calendar.user.controller;

import com.calendar.user.model.User;
import com.calendar.user.model.UserRequest;

import java.util.List;

public interface UserController {

    public User getUser(String id);

    public User createUser(UserRequest userRequest);

    public List<User> getAllUsers();
}
