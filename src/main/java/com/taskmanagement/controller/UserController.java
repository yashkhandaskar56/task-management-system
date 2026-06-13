package com.taskmanagement.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanagement.Repository.UserRepository;
import com.taskmanagement.entity.User;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/profile")
    public User getProfile(Principal principal) {

        return userRepository.findByEmail(principal.getName())
                .orElseThrow(() ->
                        new RuntimeException("User Not Found"));
    }

}
