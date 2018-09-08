package com.metademy.microservices.dao;

import com.metademy.microservices.model.Request;

public interface UsersDao {
	public Request saveUserInformation(Request user);
}
