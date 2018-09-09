package com.metademy.microservices.model;

public class RequestDetails {
	private BusinessQuery businessQuerie;
	private DebtEquityRaising debtEquityRaising;
	private EquityMezzanine equityMezzanine;
	private NonEquityMezzanine nonEquityMezzanine;

	public BusinessQuery getBusinessQuerie() {
		return businessQuerie;
	}

	public void setBusinessQuerie(BusinessQuery businessQuerie) {
		this.businessQuerie = businessQuerie;
	}

	public DebtEquityRaising getDebtEquityRaising() {
		return debtEquityRaising;
	}

	public void setDebtEquityRaising(DebtEquityRaising debtEquityRaising) {
		this.debtEquityRaising = debtEquityRaising;
	}

	public EquityMezzanine getEquityMezzanine() {
		return equityMezzanine;
	}

	public void setEquityMezzanine(EquityMezzanine equityMezzanine) {
		this.equityMezzanine = equityMezzanine;
	}

	public NonEquityMezzanine getNonEquityMezzanine() {
		return nonEquityMezzanine;
	}

	public void setNonEquityMezzanine(NonEquityMezzanine nonEquityMezzanine) {
		this.nonEquityMezzanine = nonEquityMezzanine;
	}

}
