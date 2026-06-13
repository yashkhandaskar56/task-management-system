package com.taskmanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDTO {
	
	@NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email
    private String email;

    private String mobileNumber;

    @NotBlank
    private String password;

}
