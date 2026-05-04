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

    User found = userRepo.findByEmail(user.getEmail());
    if (found != null && found.getPassword().equals(user.getPassword())) {
        return found;
    }
    return null;
}}
}
