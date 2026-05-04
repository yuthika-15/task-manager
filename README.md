##Task Manager Application

# Live Demo
https://task-manager-production-b065.up.railway.app/

#Overview
This is a full-stack Task Manager application built using Spring Boot and MySQL. It allows users to register, log in, and manage tasks
through a simple web interface. The application is deployed on Railway and demonstrates end-to-end backend and frontend integration.

#Features
- User registration and login
- Role-based access (Admin and Member)
- Admin can create tasks
- Members can view tasks
- Task status tracking (Pending, Done, Overdue)
- Mark tasks as completed
- Deadline-based task management
- Deployed and accessible via public URL

#Tech Stack

- Backend: Spring Boot (Java)
- Frontend: HTML, JavaScript
- Database: MySQL
- Deployment: Railway

#Project Structure

- Controller Layer: Handles HTTP requests
- Repository Layer: Manages database operations using JPA
- Model Layer: Defines entities like User and Task
- Frontend: Single HTML file with embedded JavaScript

#API Endpoints

- POST /login → User login
- POST /signup → User registration
- GET /tasks → Fetch all tasks
- POST /tasks → Create a new task (Admin only)
- PUT /tasks/{id}?status=DONE → Mark task as completed

#How to Run Locally

1. Clone the repository
2. Configure MySQL in application.properties
3. Run the Spring Boot application
4. Open the application in browser at localhost

#Deployment

The application is deployed on Railway. The backend is connected to a MySQL database hosted on Railway.

#Notes

- This project uses basic authentication logic for demonstration purposes
- Passwords are stored in plain text (not recommended for production)
- Can be enhanced using password hashing and Spring Security
-

Author

Final Year Electronics and Telecommunication Student
Interested in Backend Development and Software Engineering
