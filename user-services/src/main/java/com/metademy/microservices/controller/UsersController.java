package com.metademy.microservices.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.metademy.microservices.model.CustomResponse;
import com.metademy.microservices.model.Request;
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
	public ResponseEntity<CustomResponse> create(@RequestBody @Valid Request user) {
		Request result = userService.saveUserInformation(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getUserId())
				.toUri();

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(location);
		return new ResponseEntity<CustomResponse>(new CustomResponse(result.getRequestId(), "Request submitted successfully"), responseHeaders, HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public List<Request> retrieveCoursesForStudent() {
		Request user = new Request("test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test",
				"test", "test", "test", "test",1l);
		return Arrays.asList(user);
	}
}
