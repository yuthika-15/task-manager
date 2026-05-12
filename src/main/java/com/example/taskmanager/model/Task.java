package com.example.taskmanager.model;

import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String status;
    private LocalDate deadline;
    
    public LocalDate getDeadline() { return deadline; }
    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}