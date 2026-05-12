package com.example.taskmanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.UserRepository;

@SpringBootApplication
public class TaskmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
	}
	@Bean
	CommandLineRunner init(UserRepository repo) {
	    return args -> {

	        if (repo.findByEmail("newadmin@gmail.com") == null) {

	            User admin = new User();
	            admin.setName("Admin");
	            admin.setEmail("newadmin@gmail.com");
	            admin.setPassword("123");
	            admin.setRole("ADMIN");

	            repo.save(admin);
	        }
	    };
	}
}