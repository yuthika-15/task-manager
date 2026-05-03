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
	        if (repo.count() == 0) { 

	            User admin = new User();
	            admin.setName("Admin");
	            admin.setEmail("admin@gmail.com");
	            admin.setPassword("123");
	            admin.setRole("ADMIN");

	            User member = new User();
	            member.setName("Member");
	            member.setEmail("member@gmail.com");
	            member.setPassword("123");
	            member.setRole("MEMBER");

	            repo.save(admin);
	            repo.save(member);
	        }
	    };
	}

}
