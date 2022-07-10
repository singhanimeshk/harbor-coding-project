package com.calendar.user.controller.impl;

import com.calendar.user.controller.UserController;
import com.calendar.user.model.User;
import com.calendar.user.model.UserRequest;
import com.calendar.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("users")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }

    @GetMapping
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    @ResponseBody
    public User createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
}
