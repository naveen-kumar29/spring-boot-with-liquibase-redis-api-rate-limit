package com.example.liquibase.service;

import com.example.liquibase.entites.User;
import com.example.liquibase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @CachePut(value = "userCache", key = "#user.id")
    public String createUser(User user) {
        userRepository.save(user);
        return "Data inserted successfully";
    }

    @Cacheable(value = "userCache", key = "#id")
    public User getUser(Long id) {

            return userRepository.findById(id).orElse(null);

    }

    @CacheEvict(value = "userCache", key = "#id")
    public String deleteUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user+" Deleted successfully";
    }
}
