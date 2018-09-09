package com.metademy.microservices.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BusinessQuery")
public class BusinessQuery {

	private String businessQueryId;
	private String requestId;
	private String query;
	private Long id;

	public String getBusinessQueryId() {
		return businessQueryId;
	}

	public void setBusinessQueryId(String businessQueryId) {
		this.businessQueryId = businessQueryId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
