package com.metademy.microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metademy.microservices.dao.AuthorisedPersonDao;
import com.metademy.microservices.model.Request;
import com.metademy.microservices.model.RequestComments;
import com.metademy.microservices.model.RequestDetails;

@Service
public class AuthorisedPersonServiceImpl implements AuthorisedPersonService {

	private final AuthorisedPersonDao authorisedPersonDao;

	@Autowired
	public AuthorisedPersonServiceImpl(AuthorisedPersonDao authorisedPersonDao) {
		this.authorisedPersonDao = authorisedPersonDao;
	}
	
	@Override
	public RequestComments updateRequest(RequestComments requestComments) {
		return this.authorisedPersonDao.updateRequest(requestComments);
	}

	@Override
	public List<Request> getAllRequests(Request request) {
		return this.authorisedPersonDao.getAllRequests(request);
	}

	@Override
	public RequestDetails getRequestDetails(Request request) {
		return this.getRequestDetails(request);
	}

}
