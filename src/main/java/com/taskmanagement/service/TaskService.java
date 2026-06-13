package com.taskmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taskmanagement.Repository.TaskRepository;
import com.taskmanagement.Repository.UserRepository;
import com.taskmanagement.dto.TaskRequestDto;
import com.taskmanagement.entity.Task;
import com.taskmanagement.entity.User;

@Service
public class TaskService {
	
	 private final TaskRepository taskRepository;
	    private final UserRepository userRepository;

	    public TaskService(TaskRepository taskRepository,
	                       UserRepository userRepository) {
	        this.taskRepository = taskRepository;
	        this.userRepository = userRepository;
	    }

	    public Task createTask(TaskRequestDto dto, String email) {

	        User user = userRepository.findByEmail(email)
	                .orElseThrow(() -> new RuntimeException("User not found"));

	        Task task = Task.builder()
	                .title(dto.getTitle())
	                .description(dto.getDescription())
	                .dueDate(dto.getDueDate())
	                .status(dto.getStatus())
	                .user(user)
	                .build();

	        return taskRepository.save(task);
	    }

	    public Task updateTask(Long id, TaskRequestDto dto) {

	        Task task = taskRepository.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException("Task Not Found"));

	        task.setTitle(dto.getTitle());
	        task.setDescription(dto.getDescription());
	        task.setDueDate(dto.getDueDate());
	        task.setStatus(dto.getStatus());

	        return taskRepository.save(task);
	    }
	    
	    public List<Task> getAllTasks() {
	        return taskRepository.findAll();
	    }

	    public Task getTaskById(Long id) {
	        return taskRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Task not found"));
	    }

	    public void deleteTask(Long id) {
	        taskRepository.deleteById(id);
	    }

}
