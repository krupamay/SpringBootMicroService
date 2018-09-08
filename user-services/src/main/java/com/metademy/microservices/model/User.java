package com.metademy.microservices.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
	@Id
	private String requestId;
	private String userId;
	private String userCategory;
	private String purpose;
	private String entityName;
	private String entityConstitution;
	private String entityAddress;
	private String entityEmail;
	private String entityPhone;
	private String entityProductDetails;
	private String entityYearOfOperation;
	private String entityGrossSales;
	private String entityProfit;
	private String authPersonelId;
	private String status;

	
	public User() {

	}

	public User(String requestId, String userId, String userCategory, String purpose, String entityName,
			String entityConstitution, String entityAddress, String entityEmail, String entityPhone,
			String entityProductDetails, String entityYearOfOperation, String entityGrossSales, String entityProfit,
			String authPersonelId, String status) {
		super();
		this.requestId = requestId;
		this.userId = userId;
		this.userCategory = userCategory;
		this.purpose = purpose;
		this.entityName = entityName;
		this.entityConstitution = entityConstitution;
		this.entityAddress = entityAddress;
		this.entityEmail = entityEmail;
		this.entityPhone = entityPhone;
		this.entityProductDetails = entityProductDetails;
		this.entityYearOfOperation = entityYearOfOperation;
		this.entityGrossSales = entityGrossSales;
		this.entityProfit = entityProfit;
		this.authPersonelId = authPersonelId;
		this.status = status;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserCategory() {
		return userCategory;
	}

	public void setUserCategory(String userCategory) {
		this.userCategory = userCategory;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getEntityConstitution() {
		return entityConstitution;
	}

	public void setEntityConstitution(String entityConstitution) {
		this.entityConstitution = entityConstitution;
	}

	public String getEntityAddress() {
		return entityAddress;
	}

	public void setEntityAddress(String entityAddress) {
		this.entityAddress = entityAddress;
	}

	public String getEntityEmail() {
		return entityEmail;
	}

	public void setEntityEmail(String entityEmail) {
		this.entityEmail = entityEmail;
	}

	public String getEntityPhone() {
		return entityPhone;
	}

	public void setEntityPhone(String entityPhone) {
		this.entityPhone = entityPhone;
	}

	public String getEntityProductDetails() {
		return entityProductDetails;
	}

	public void setEntityProductDetails(String entityProductDetails) {
		this.entityProductDetails = entityProductDetails;
	}

	public String getEntityYearOfOperation() {
		return entityYearOfOperation;
	}

	public void setEntityYearOfOperation(String entityYearOfOperation) {
		this.entityYearOfOperation = entityYearOfOperation;
	}

	public String getEntityGrossSales() {
		return entityGrossSales;
	}

	public void setEntityGrossSales(String entityGrossSales) {
		this.entityGrossSales = entityGrossSales;
	}

	public String getEntityProfit() {
		return entityProfit;
	}

	public void setEntityProfit(String entityProfit) {
		this.entityProfit = entityProfit;
	}

	public String getAuthPersonelId() {
		return authPersonelId;
	}

	public void setAuthPersonelId(String authPersonelId) {
		this.authPersonelId = authPersonelId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
