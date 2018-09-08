package com.metademy.microservices.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.metademy.microservices.model.User;
import com.metademy.microservices.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UsersController {

	private final UserService userService;

	@Autowired
	UsersController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/saveUserInfo")
	public ResponseEntity<Void> create(@RequestBody @Valid User user) {
		User result = userService.saveUserInformation(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getUserId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/get")
	public List<User> retrieveCoursesForStudent() {
		User user = new User("test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test");
		return Arrays.asList(user);
	}
}
