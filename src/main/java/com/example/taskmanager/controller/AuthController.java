package com.example.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.UserRepository;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        if (user.getRole() == null) {
            user.setRole("MEMBER");
        }
        return userRepo.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userRepo.findAll().stream()
            .filter(x -> x.getEmail().equals(user.getEmail()) &&
                         x.getPassword().equals(user.getPassword()))
            .findFirst()
            .orElse(null);
    }
}