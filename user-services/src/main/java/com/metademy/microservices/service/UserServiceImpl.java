package com.metademy.microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metademy.microservices.dao.UsersDao;
import com.metademy.microservices.model.BusinessQuery;
import com.metademy.microservices.model.DebtEquityRaising;
import com.metademy.microservices.model.EquityMezzanine;
import com.metademy.microservices.model.NonEquityMezzanine;
import com.metademy.microservices.model.Request;
import com.metademy.microservices.model.RequestDetails;

@Service
public class UserServiceImpl implements UserService {

	private final UsersDao usersDao;

	@Autowired
	UserServiceImpl(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	public Request saveUserRequests(Request request) {
		usersDao.saveUserRequests(request);
		return request;
	}

	@Override
	public List<Request> getAllRequests(Request request) {
		return this.usersDao.getAllRequests(request);
	}

	@Override
	public RequestDetails getRequestDetails(Request request) {
		return this.usersDao.getRequestDetails(request);
	}

	@Override
	public BusinessQuery createBusinessQuery(BusinessQuery businessQuery) {
		usersDao.createBusinessQuery(businessQuery);
		return businessQuery;
	}

	@Override
	public DebtEquityRaising createDebtEquityRaising(DebtEquityRaising debtEquityRaising) {
		usersDao.createDebtEquityRaising(debtEquityRaising);
		return debtEquityRaising;

	}

	@Override
	public EquityMezzanine saveEquityMezzanine(EquityMezzanine equityMezzanine) {
		usersDao.saveEquityMezzanine(equityMezzanine);
		return equityMezzanine;
	}

	@Override
	public NonEquityMezzanine saveNonEquityMezzanine(NonEquityMezzanine nonEquityMezzanine) {
		usersDao.saveNonEquityMezzanine(nonEquityMezzanine);
		return nonEquityMezzanine;
	}

}
