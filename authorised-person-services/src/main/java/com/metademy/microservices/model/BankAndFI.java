package com.metademy.microservices.model;

public class BankAndFI {

	private String bankFIName;
	private String fundBasedWorkingCapital;
	private String nonFundBasedWorkingCapital;
	private String shortTermLoan;
	private String longTermLoan;

	public String getBankFIName() {
		return bankFIName;
	}

	public void setBankFIName(String bankFIName) {
		this.bankFIName = bankFIName;
	}

	public String getFundBasedWorkingCapital() {
		return fundBasedWorkingCapital;
	}

	public void setFundBasedWorkingCapital(String fundBasedWorkingCapital) {
		this.fundBasedWorkingCapital = fundBasedWorkingCapital;
	}

	public String getNonFundBasedWorkingCapital() {
		return nonFundBasedWorkingCapital;
	}

	public void setNonFundBasedWorkingCapital(String nonFundBasedWorkingCapital) {
		this.nonFundBasedWorkingCapital = nonFundBasedWorkingCapital;
	}

	public String getShortTermLoan() {
		return shortTermLoan;
	}

	public void setShortTermLoan(String shortTermLoan) {
		this.shortTermLoan = shortTermLoan;
	}

	public String getLongTermLoan() {
		return longTermLoan;
	}

	public void setLongTermLoan(String longTermLoan) {
		this.longTermLoan = longTermLoan;
	}

}
