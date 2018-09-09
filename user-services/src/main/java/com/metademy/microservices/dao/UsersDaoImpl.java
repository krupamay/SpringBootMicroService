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
	public Request saveUserInformation(Request request) {
		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "id"));
		List<Request> requests = mongoTemplate.find(query, Request.class);
		if (requests.isEmpty()) {
			request.setRequestId("REQ0000001");
			request.setId(1l);
		} else {
			Long id = requests.get(0).getId() + 1;
			request.setId(id);
			request.setRequestId("REQ000000" + (id));
		}
		mongoTemplate.save(request);
		return request;
	}

}
