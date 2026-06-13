# Task Management System

## Overview

Task Management System is a Spring Boot REST API application that provides:

* User Registration
* User Login with JWT Authentication
* User Profile Management
* Task Creation
* Task Update
* Task Deletion
* Task Details Retrieval
* Task Listing

The application uses Spring Boot, Spring Security, JWT Authentication, Spring Data JPA, and Microsoft SQL Server.

---

## Technologies Used

* Java 17
* Spring Boot 3
* Spring Security
* JWT Authentication
* Spring Data JPA
* Hibernate
* Microsoft SQL Server
* Maven
* Swagger OpenAPI

---

## Project Structure

```text
src/main/java/com/taskmanagement

├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── config
```

---

## Database Configuration

Create a database:

```sql
CREATE DATABASE taskmanagement;
```

Update application.properties:

```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=taskmanagement;encrypt=true;trustServerCertificate=true
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Running the Application

Clone Repository:

```bash
git clone https://github.com/yashkhandaskar56/task-management-system.git
```

Move into project:

```bash
cd task-management-system
```

Build Project:

```bash
mvn clean install
```

Run Application:

```bash
mvn spring-boot:run
```

Application will start on:

```text
http://localhost:8080
```

---

## Swagger Documentation

Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## Authentication Flow

### Register User

POST

```text
/api/auth/register
```

### Login User

POST

```text
/api/auth/login
```

After successful login, JWT token will be generated.

Use JWT Token:

```text
Authorization: Bearer <JWT_TOKEN>
```

---

## Available APIs

### Authentication

* POST /api/auth/register
* POST /api/auth/login

### User

* GET /api/user/profile

### Task

* POST /api/tasks/add
* PUT /api/tasks/update/{id}
* DELETE /api/tasks/delete/{id}
* GET /api/tasks/get/{id}
* GET /api/tasks/All

---

## Features

* JWT Based Authentication
* Secure REST APIs
* User Profile Management
* Task CRUD Operations
* MSSQL Database Integration
* Swagger Documentation

---

## Author

Yash Khandaskar

Backend Java Developer
