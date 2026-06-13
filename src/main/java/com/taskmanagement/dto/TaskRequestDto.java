package com.taskmanagement.dto;

import java.time.LocalDate;

import com.taskmanagement.entity.TaskStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDto {
	
	 private String title;

	    private String description;

	    private LocalDate dueDate;

	    private TaskStatus status;

}
