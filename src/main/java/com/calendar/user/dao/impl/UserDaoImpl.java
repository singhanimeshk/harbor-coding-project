package com.calendar.user.dao.impl;

import com.calendar.user.dao.UserDao;
import com.calendar.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserDaoImpl implements UserDao {

    private Map<String, User> userMap;

    public UserDaoImpl() {
        this.userMap = new HashMap<>();
    }

    @Override
    public User getUser(String id) {
        return userMap.get(id);
    }

    @Override
    public void createUser(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }
}
