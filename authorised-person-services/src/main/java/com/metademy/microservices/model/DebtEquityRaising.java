package com.metademy.microservices.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DebtEquityRaising")
public class DebtEquityRaising {
	private String debtEquityRaisingId;
	private String requestId;
	private List<DocumentUploaded> documentsUploaded;
	private String requirementType;
	private List<BankAndFI> bankAndFIs;
	private String annualTurnover;
	private String annualCashProfit;

	public String getDebtEquityRaisingId() {
		return debtEquityRaisingId;
	}

	public void setDebtEquityRaisingId(String debtEquityRaisingId) {
		this.debtEquityRaisingId = debtEquityRaisingId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public List<DocumentUploaded> getDocumentsUploaded() {
		return documentsUploaded;
	}

	public void setDocumentsUploaded(List<DocumentUploaded> documentsUploaded) {
		this.documentsUploaded = documentsUploaded;
	}

	public String getRequirementType() {
		return requirementType;
	}

	public void setRequirementType(String requirementType) {
		this.requirementType = requirementType;
	}

	public List<BankAndFI> getBankAndFIs() {
		return bankAndFIs;
	}

	public void setBankAndFIs(List<BankAndFI> bankAndFIs) {
		this.bankAndFIs = bankAndFIs;
	}

	public String getAnnualTurnover() {
		return annualTurnover;
	}

	public void setAnnualTurnover(String annualTurnover) {
		this.annualTurnover = annualTurnover;
	}

	public String getAnnualCashProfit() {
		return annualCashProfit;
	}

	public void setAnnualCashProfit(String annualCashProfit) {
		this.annualCashProfit = annualCashProfit;
	}

}
