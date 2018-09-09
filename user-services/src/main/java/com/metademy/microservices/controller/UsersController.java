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

import com.metademy.microservices.model.BusinessQuery;
import com.metademy.microservices.model.CustomResponse;
import com.metademy.microservices.model.DebtEquityRaising;
import com.metademy.microservices.model.EquityMezzanine;
import com.metademy.microservices.model.NonEquityMezzanine;
import com.metademy.microservices.model.Request;
import com.metademy.microservices.model.RequestDetails;
import com.metademy.microservices.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UsersController {

	private final UserService userService;

	@Autowired
	UsersController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/saveUserRequests")
	public ResponseEntity<CustomResponse> saveUserRequests(@RequestBody @Valid Request request) {
		Request result = userService.saveUserRequests(request);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getUserId())
				.toUri();

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(location);
		return new ResponseEntity<CustomResponse>(
				new CustomResponse(result.getRequestId(), "User Request submitted successfully"), responseHeaders,
				HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public List<Request> retrieveCoursesForStudent() {
		Request user = new Request("test", "test", "test", "test", "test", "test", "test", "test", "test", "test",
				"test", "test", "test", "test", "test", 1l);
		return Arrays.asList(user);
	}

	@PostMapping("/getAllRequests")
	public ResponseEntity<List<Request>> getAllRequests(@RequestBody @Valid Request request) {
		List<Request> result = this.userService.getAllRequests(request);
		return new ResponseEntity<List<Request>>(result, HttpStatus.OK);
	}

	@PostMapping("/getRequestDetails")
	public ResponseEntity<RequestDetails> getRequestDetails(@RequestBody @Valid Request request) {
		RequestDetails result = this.userService.getRequestDetails(request);
		return new ResponseEntity<RequestDetails>(result, HttpStatus.OK);
	}

	@PostMapping("/createBusinessQuery")
	public ResponseEntity<CustomResponse> createBusinessQuery(@RequestBody @Valid BusinessQuery businessQuery) {
		BusinessQuery result = userService.createBusinessQuery(businessQuery);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getBusinessQueryId()).toUri();

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(location);
		return new ResponseEntity<CustomResponse>(
				new CustomResponse(result.getBusinessQueryId(), "Business Query submitted successfully"),
				responseHeaders, HttpStatus.CREATED);
	}

	@PostMapping("/createDebtEquityRaising")
	public ResponseEntity<CustomResponse> createDebtEquityRaising(
			@RequestBody @Valid DebtEquityRaising debtEquityRaising) {
		DebtEquityRaising result = userService.createDebtEquityRaising(debtEquityRaising);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getDebtEquityRaisingId()).toUri();

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(location);
		return new ResponseEntity<CustomResponse>(
				new CustomResponse(result.getDebtEquityRaisingId(), "DebtEquityRaising Request submitted successfully"),
				responseHeaders, HttpStatus.CREATED);
	}

	@PostMapping("/saveEquityMezzanine")
	public ResponseEntity<CustomResponse> saveEquityMezzanine(@RequestBody @Valid EquityMezzanine equityMezzanine) {
		EquityMezzanine result = userService.saveEquityMezzanine(equityMezzanine);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getEquityMezzanineId()).toUri();

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(location);
		return new ResponseEntity<CustomResponse>(
				new CustomResponse(result.getEquityMezzanineId(), "EquityMezzanine Request submitted successfully"),
				responseHeaders, HttpStatus.CREATED);
	}

	@PostMapping("/saveNonEquityMezzanine")
	public ResponseEntity<CustomResponse> saveNonEquityMezzanine(
			@RequestBody @Valid NonEquityMezzanine nonEquityMezzanine) {
		NonEquityMezzanine result = userService.saveNonEquityMezzanine(nonEquityMezzanine);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(result.getNonEquityMezzanineId()).toUri();

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(location);
		return new ResponseEntity<CustomResponse>(new CustomResponse(result.getNonEquityMezzanineId(),
				"NonEquityMezzanine Request submitted successfully"), responseHeaders, HttpStatus.CREATED);
	}
}
