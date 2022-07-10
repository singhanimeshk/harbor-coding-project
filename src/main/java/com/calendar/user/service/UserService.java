package com.calendar.user.service;

import com.calendar.user.model.User;
import com.calendar.user.model.UserRequest;

import java.util.List;

public interface UserService {

    public User getUser(String id);

    public User createUser(UserRequest userRequest);

    public List<User> getAllUsers();
}
