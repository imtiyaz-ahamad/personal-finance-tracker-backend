package com.immu.controller;

import com.immu.model.User;
import com.immu.service.UserService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users") 
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		int result = userService.registerUser(user);
		return result > 0 ? "User registered successfully!" : "User registration failed!";
	}

	@GetMapping("/login/{email}")
	public User getUserByEmail(@PathVariable String email) {
		return userService.getUserByEmail(email);
	}

	// New endpoint to fetch user details (name and email)
	@GetMapping("/details/{userId}")
	public User getUserDetails(@PathVariable int userId) {
		return userService.getUserById(userId);
	}
}
