package com.metademy.microservices.dao;

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
import com.metademy.microservices.model.RequestDetails;

@Repository
public class UsersDaoImpl implements UsersDao {

	private final MongoTemplate mongoTemplate;

	@Autowired
	public UsersDaoImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Request saveUserRequests(Request request) {
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

	@Override
	public List<Request> getAllRequests(Request request) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").is(request.getUserId()));
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

	@Override
	public BusinessQuery createBusinessQuery(BusinessQuery businessQuery) {
		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "id"));
		List<BusinessQuery> businessQueries = mongoTemplate.find(query, BusinessQuery.class);
		if (businessQueries.isEmpty()) {
			businessQuery.setRequestId("BQ0000001");
			businessQuery.setId(1l);
		} else {
			Long id = businessQueries.get(0).getId() + 1;
			businessQuery.setId(id);
			businessQuery.setBusinessQueryId("BQ000000" + (id));
		}
		mongoTemplate.save(businessQuery);
		return businessQuery;
	}

	@Override
	public DebtEquityRaising createDebtEquityRaising(DebtEquityRaising debtEquityRaising) {
		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "id"));
		List<DebtEquityRaising> debtEquityRaisings = mongoTemplate.find(query, DebtEquityRaising.class);
		if (debtEquityRaisings.isEmpty()) {
			debtEquityRaising.setRequestId("DER0000001");
			debtEquityRaising.setId(1l);
		} else {
			Long id = debtEquityRaisings.get(0).getId() + 1;
			debtEquityRaising.setId(id);
			debtEquityRaising.setDebtEquityRaisingId("DER000000" + (id));
		}
		mongoTemplate.save(debtEquityRaising);
		return debtEquityRaising;
	}

	@Override
	public EquityMezzanine saveEquityMezzanine(EquityMezzanine equityMezzanine) {
		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "id"));
		List<EquityMezzanine> equityMezzanines = mongoTemplate.find(query, EquityMezzanine.class);
		if (equityMezzanines.isEmpty()) {
			equityMezzanine.setEquityMezzanineId("EQM0000001");
			equityMezzanine.setId(1l);
		} else {
			Long id = equityMezzanines.get(0).getId() + 1;
			equityMezzanine.setId(id);
			equityMezzanine.setEquityMezzanineId("EQM000000" + (id));
		}
		mongoTemplate.save(equityMezzanine);
		return equityMezzanine;
	}

	@Override
	public NonEquityMezzanine saveNonEquityMezzanine(NonEquityMezzanine nonEquityMezzanine) {
		Query query = new Query();
		query.limit(1);
		query.with(new Sort(Sort.Direction.DESC, "id"));
		List<EquityMezzanine> nonEquityMezzanines = mongoTemplate.find(query, EquityMezzanine.class);
		if (nonEquityMezzanines.isEmpty()) {
			nonEquityMezzanine.setNonEquityMezzanineId("EQM0000001");
			nonEquityMezzanine.setId(1l);
		} else {
			Long id = nonEquityMezzanines.get(0).getId() + 1;
			nonEquityMezzanine.setId(id);
			nonEquityMezzanine.setNonEquityMezzanineId("EQM000000" + (id));
		}
		mongoTemplate.save(nonEquityMezzanine);
		return nonEquityMezzanine;
	}

}
