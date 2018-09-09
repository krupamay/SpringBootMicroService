package com.metademy.microservices.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.metademy.microservices.model.BusinessQuery;
import com.metademy.microservices.model.DebtEquityRaising;
import com.metademy.microservices.model.EquityMezzanine;
import com.metademy.microservices.model.NonEquityMezzanine;
import com.metademy.microservices.model.Request;
import com.metademy.microservices.model.RequestComments;
import com.metademy.microservices.model.RequestDetails;

@Repository
public class AuthorisedPersonDaoImpl implements AuthorisedPersonDao {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public AuthorisedPersonDaoImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public RequestComments updateRequest(RequestComments requestComments) {
		Query query = new Query();
		query.addCriteria(Criteria.where("requestId").is(requestComments.getRequestId()));
		Request request = mongoTemplate.findOne(query, Request.class);
		request.setAuthPersonelId(requestComments.getPersonnelId());
		request.setStatus("Waiting for further Inputs");
		mongoTemplate.save(request);
		query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "id"));
		List<RequestComments> comments = mongoTemplate.find(query, RequestComments.class);
		LocalDateTime localDateTime = LocalDateTime.now();
		requestComments.setDateTime(localDateTime.toString());
		if (comments.isEmpty()) {
			requestComments.setCommentId("COM0000001");
			requestComments.setId(1l);
		} else {
			Long id = comments.get(0).getId() + 1;
			requestComments.setId(id);
			requestComments.setCommentId("COM000000" + (id));
		}
		mongoTemplate.save(requestComments);
		return requestComments;
	}

	@Override
	public List<Request> getAllRequests(Request request) {
		Query query = new Query();
		query.addCriteria(Criteria.where("authPersonelId").is(request.getAuthPersonelId())
				.orOperator(Criteria.where("status").is("Not Picked"))
				.orOperator(Criteria.where("authPersonelId").is(null)));
		List<Request> result = mongoTemplate.find(query, Request.class);
		return result;
	}

	@Override
	public RequestDetails getRequestDetails(Request request) {
		Query query = null;
		RequestDetails requestDetails = new RequestDetails();
		if ("BusinessQuery".equalsIgnoreCase(request.getPurpose())) {
			query = new Query();
			query.addCriteria(Criteria.where("requestId").is(request.getRequestId()));
			requestDetails.setBusinessQuerie(mongoTemplate.findOne(query, BusinessQuery.class));
		} else if ("DebtEquityRaising".equalsIgnoreCase(request.getRequestId())) {
			query = new Query();
			query.addCriteria(Criteria.where("requestId").is(request.getRequestId()));
			DebtEquityRaising debtEquityRaising = mongoTemplate.findOne(query, DebtEquityRaising.class);
			requestDetails.setDebtEquityRaising(debtEquityRaising);
			if ("NonEquityMezzanine".equalsIgnoreCase(debtEquityRaising.getRequirementType())) {
				query = new Query();
				query.addCriteria(Criteria.where("debtEquityRaisingId").is(debtEquityRaising.getDebtEquityRaisingId()));
				requestDetails.setNonEquityMezzanine(mongoTemplate.findOne(query, NonEquityMezzanine.class));
			} else if ("EquityMezzanine".equalsIgnoreCase(debtEquityRaising.getRequirementType())) {
				query = new Query();
				query.addCriteria(Criteria.where("debtEquityRaisingId").is(debtEquityRaising.getDebtEquityRaisingId()));
				requestDetails.setEquityMezzanine(mongoTemplate.findOne(query, EquityMezzanine.class));
			}
		}
		return requestDetails;
	}

}
