package com.example.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.UserRepository;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;

import java.util.List;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/tasks")
@CrossOrigin
public class TaskController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TaskRepository repo;

    @GetMapping
    public List<Task> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Task create(@RequestBody Task t, @RequestParam String email) {

        User user = userRepo.findByEmail(email);

        if (user == null || !user.getRole().equals("ADMIN")) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        }

        return repo.save(t);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestParam("status") String status) {
        Task task = repo.findById(id).orElseThrow();
        task.setStatus(status);
        return repo.save(task);
    }
}