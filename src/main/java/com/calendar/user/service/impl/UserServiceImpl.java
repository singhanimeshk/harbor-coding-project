package com.calendar.user.service.impl;

import com.calendar.user.dao.UserDao;
import com.calendar.user.model.User;
import com.calendar.user.model.UserRequest;
import com.calendar.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(@Autowired UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(String id) {
        return userDao.getUser(id);
    }

    @Override
    public User createUser(UserRequest userRequest) {
        User user = new User(userRequest);
        userDao.createUser(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
