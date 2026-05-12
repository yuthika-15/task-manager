package com.example.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.taskmanager.model.Project;
import com.example.taskmanager.repository.ProjectRepository;

import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectRepository repo;

    @GetMapping
    public List<Project> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Project create(@RequestBody Project p) {
        return repo.save(p);
    }
}