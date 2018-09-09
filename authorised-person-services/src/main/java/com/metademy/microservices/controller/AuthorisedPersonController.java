package com.metademy.microservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.metademy.microservices.model.CustomResponse;
import com.metademy.microservices.model.Request;
import com.metademy.microservices.model.RequestComments;
import com.metademy.microservices.model.RequestDetails;
import com.metademy.microservices.service.AuthorisedPersonService;

@RestController
@RequestMapping("/api/auth-person")
public class AuthorisedPersonController {
	
	private final AuthorisedPersonService authorisedPersonService;
	
	@Autowired
	public AuthorisedPersonController(AuthorisedPersonService authorisedPersonService) {
		this.authorisedPersonService = authorisedPersonService;
	}
	
	@PostMapping("/updateRequest")
	public ResponseEntity<CustomResponse> updateRequest(@RequestBody @Valid RequestComments requestComments) {
		RequestComments result = authorisedPersonService.updateRequest(requestComments);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(requestComments.getCommentId())
				.toUri();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(location);
		return new ResponseEntity<CustomResponse>(new CustomResponse(result.getCommentId(), "Comments submitted successfully"), responseHeaders, HttpStatus.CREATED);
	}
	@PostMapping("/getAllRequests")
	public ResponseEntity<List<Request>> getAllRequests(@RequestBody @Valid Request request) {
		List<Request> result = this.authorisedPersonService.getAllRequests(request);
		return new ResponseEntity<List<Request>>(result, HttpStatus.OK);
	}
	
	@PostMapping("/getRequestDetails")
	public ResponseEntity<RequestDetails> getRequestDetails(@RequestBody @Valid Request request) {
		RequestDetails result = this.authorisedPersonService.getRequestDetails(request);
		return new ResponseEntity<RequestDetails>(result, HttpStatus.OK);
	}
}
