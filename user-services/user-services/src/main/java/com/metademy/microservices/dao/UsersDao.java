package com.metademy.microservices.dao;

import com.metademy.microservices.model.User;

public interface UsersDao {
	public User saveUserInformation(User user);
}
