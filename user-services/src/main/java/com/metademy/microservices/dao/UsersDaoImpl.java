package com.metademy.microservices.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.metademy.microservices.model.Request;

@Repository
public class UsersDaoImpl implements UsersDao {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public UsersDaoImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Request saveUserInformation(Request user) {
		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "id"));
		List<Request> users = mongoTemplate.find(query, Request.class);
		if (users.isEmpty()) {
			user.setRequestId("REQ0000001");
			user.setId(1l);
		} else {
			Long id = users.get(0).getId() + 1;
			user.setId(id);
			user.setRequestId("REQ000000" + (id));
		}
		mongoTemplate.save(user);
		return user;
	}

}
