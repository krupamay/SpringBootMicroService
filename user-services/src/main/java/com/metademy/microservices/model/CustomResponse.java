package com.metademy.microservices.model;

public class CustomResponse {
	private String resultId;
	private String message;

	public CustomResponse(String resultId, String message) {
		super();
		this.resultId = resultId;
		this.message = message;
	}

	public String getResultId() {
		return resultId;
	}

	public void setResultId(String resultId) {
		this.resultId = resultId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
