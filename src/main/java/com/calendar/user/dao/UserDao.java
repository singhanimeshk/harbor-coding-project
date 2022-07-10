package com.calendar.user.dao;

import com.calendar.user.model.User;

import java.util.List;

public interface UserDao {

    public User getUser(String id);

    public void createUser(User user);

    public List<User> getAllUsers();
}
