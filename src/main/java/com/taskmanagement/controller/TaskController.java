package com.taskmanagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.dto.TaskRequestDto;
import com.taskmanagement.entity.Task;
import com.taskmanagement.service.TaskService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	
	 private final TaskService taskService;

	    public TaskController(TaskService taskService) {
	        this.taskService = taskService;
	    }

	    @PostMapping("/add")
	    public Task createTask(
	            @RequestBody TaskRequestDto dto,
	            Principal principal) {

	        System.out.println("Principal = " + principal);

	        return taskService.createTask(
	                dto,
	                principal.getName());
	    }
	    
	    @PutMapping("/update/{id}")
	    public Task updateTask(
	            @PathVariable Long id,
	            @RequestBody TaskRequestDto dto) {

	        return taskService.updateTask(id, dto);
	    }

	    @GetMapping("/All")
	    public List<Task> getAllTasks() {
	        return taskService.getAllTasks();
	    }

	    @GetMapping("/get/{id}")
	    public Task getTaskById(
	            @PathVariable Long id) {

	        return taskService.getTaskById(id);
	    }

	    @DeleteMapping("/delete/{id}")
	    public String deleteTask(
	            @PathVariable Long id) {

	        taskService.deleteTask(id);
	        return "Task Deleted Successfully";
	    }

}
