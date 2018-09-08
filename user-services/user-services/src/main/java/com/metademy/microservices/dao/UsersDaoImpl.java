package com.metademy.microservices.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.metademy.microservices.model.User;

@Repository
public class UsersDaoImpl implements UsersDao {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public UsersDaoImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public User saveUserInformation(User user) {
		mongoTemplate.save(user);
		return user;
	}

}
