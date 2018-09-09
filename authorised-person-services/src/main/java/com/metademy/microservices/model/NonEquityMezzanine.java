package com.metademy.microservices.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "NonEquityMezzanine")
public class NonEquityMezzanine {

	private String nonEquityMezzanineId;
	private String debtEquityRaisingId;
	private String collateralSecurityDesc;
	private String collateralSecurityValue;
	private String intendedUse;
	private String tenure;

	public String getNonEquityMezzanineId() {
		return nonEquityMezzanineId;
	}

	public void setNonEquityMezzanineId(String nonEquityMezzanineId) {
		this.nonEquityMezzanineId = nonEquityMezzanineId;
	}

	public String getDebtEquityRaisingId() {
		return debtEquityRaisingId;
	}

	public void setDebtEquityRaisingId(String debtEquityRaisingId) {
		this.debtEquityRaisingId = debtEquityRaisingId;
	}

	public String getCollateralSecurityDesc() {
		return collateralSecurityDesc;
	}

	public void setCollateralSecurityDesc(String collateralSecurityDesc) {
		this.collateralSecurityDesc = collateralSecurityDesc;
	}

	public String getCollateralSecurityValue() {
		return collateralSecurityValue;
	}

	public void setCollateralSecurityValue(String collateralSecurityValue) {
		this.collateralSecurityValue = collateralSecurityValue;
	}

	public String getIntendedUse() {
		return intendedUse;
	}

	public void setIntendedUse(String intendedUse) {
		this.intendedUse = intendedUse;
	}

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

}
