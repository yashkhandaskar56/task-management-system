package com.taskmanagement.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.taskmanagement.Repository.UserRepository;
import com.taskmanagement.config.JwtUtil;
import com.taskmanagement.dto.AuthResponse;
import com.taskmanagement.dto.LoginRequestDTO;
import com.taskmanagement.dto.RegisterRequestDTO;
import com.taskmanagement.entity.User;

@Service
public class AuthService {
	
	 private final UserRepository userRepository;
	    private final BCryptPasswordEncoder passwordEncoder;
	    private final JwtUtil jwtUtil;
	    private final AuthenticationManager authenticationManager;

	    public AuthService(
	            UserRepository userRepository,
	            BCryptPasswordEncoder passwordEncoder,
	            JwtUtil jwtUtil,
	            AuthenticationManager authenticationManager) {

	        this.userRepository = userRepository;
	        this.passwordEncoder = passwordEncoder;
	        this.jwtUtil = jwtUtil;
	        this.authenticationManager = authenticationManager;
	    }

	    public String register(RegisterRequestDTO request) {

	        if (userRepository.existsByEmail(request.getEmail())) {
	            throw new RuntimeException("Email already exists");
	        }

	        User user = User.builder()
	                .firstName(request.getFirstName())
	                .lastName(request.getLastName())
	                .email(request.getEmail())
	                .mobileNumber(request.getMobileNumber())
	                .password(passwordEncoder.encode(request.getPassword()))
	                .build();

	        userRepository.save(user);

	        return "User Registered Successfully";
	    }

	    public AuthResponse login(LoginRequestDTO request) {

	        authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        request.getEmail(),
	                        request.getPassword()));

	        String token =
	                jwtUtil.generateToken(request.getEmail());

	        return new AuthResponse(token);
	    }

}
