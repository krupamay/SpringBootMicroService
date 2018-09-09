package com.metademy.microservices.service;

import java.util.List;

import com.metademy.microservices.model.Request;
import com.metademy.microservices.model.RequestComments;
import com.metademy.microservices.model.RequestDetails;

public interface AuthorisedPersonService {
	public RequestComments updateRequest(RequestComments requestComments);

	public List<Request> getAllRequests(Request request);

	public RequestDetails getRequestDetails(Request request);
}
