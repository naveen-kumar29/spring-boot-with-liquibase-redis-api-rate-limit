package com.example.liquibase.controller;


import com.example.liquibase.entites.User;
import com.example.liquibase.service.UserService;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.time.Duration;
import java.util.List;



@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/create")
    public String createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @GetMapping("/api/get-users/{id}")
    public User getUser(@PathVariable  Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping("/api/delete-users/{id}")
    public String deleteUser(@PathVariable(value = "id") Long id) {
        return userService.deleteUser(id);
    }
}
