package com.example.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.UserRepository;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin
public class TaskController {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private TaskRepository repo;

    // GET all tasks
    @GetMapping
    public List<Task> getAll() {
        return repo.findAll();   //  NO JWT here
    }

    // CREATE task
    @PostMapping
    public Task create(@RequestBody Task t,
                       @RequestParam String email) {

        System.out.println("EMAIL RECEIVED: " + email);

        User user = userRepo.findByEmail(email);

        System.out.println("USER FOUND: " + user);
        if (user != null) {
            System.out.println("ROLE: " + user.getRole());
        }

        if (user == null || !user.getRole().equals("ADMIN")) {
        	throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Access denied");
        }

        return repo.save(t);
    }

    // UPDATE status 
    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestParam("status") String status) {
        Task task = repo.findById(id).orElseThrow();
        task.setStatus(status);
        return repo.save(task);
    }
}