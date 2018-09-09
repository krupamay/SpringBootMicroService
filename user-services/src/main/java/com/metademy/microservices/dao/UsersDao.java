package com.metademy.microservices.dao;

import java.util.List;

import com.metademy.microservices.model.BusinessQuery;
import com.metademy.microservices.model.DebtEquityRaising;
import com.metademy.microservices.model.EquityMezzanine;
import com.metademy.microservices.model.NonEquityMezzanine;
import com.metademy.microservices.model.Request;
import com.metademy.microservices.model.RequestDetails;

public interface UsersDao {
	public Request saveUserRequests(Request request);

	public List<Request> getAllRequests(Request request);

	public RequestDetails getRequestDetails(Request request);

	public BusinessQuery createBusinessQuery(BusinessQuery businessQuery);

	public DebtEquityRaising createDebtEquityRaising(DebtEquityRaising debtEquityRaising);

	public EquityMezzanine saveEquityMezzanine(EquityMezzanine equityMezzanine);

	public NonEquityMezzanine saveNonEquityMezzanine(NonEquityMezzanine nonEquityMezzanine);
}
