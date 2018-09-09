package com.metademy.microservices.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "EquityMezzanine")
public class EquityMezzanine {

	private String equityMezzanineId;
	private ShareholdingStructure shareholdingStructure;
	private String cedeMajority;
	private String debtEquityRaisingId;

	public String getEquityMezzanineId() {
		return equityMezzanineId;
	}

	public void setEquityMezzanineId(String equityMezzanineId) {
		this.equityMezzanineId = equityMezzanineId;
	}

	public ShareholdingStructure getShareholdingStructure() {
		return shareholdingStructure;
	}

	public void setShareholdingStructure(ShareholdingStructure shareholdingStructure) {
		this.shareholdingStructure = shareholdingStructure;
	}

	public String getCedeMajority() {
		return cedeMajority;
	}

	public void setCedeMajority(String cedeMajority) {
		this.cedeMajority = cedeMajority;
	}

	public String getDebtEquityRaisingId() {
		return debtEquityRaisingId;
	}

	public void setDebtEquityRaisingId(String debtEquityRaisingId) {
		this.debtEquityRaisingId = debtEquityRaisingId;
	}

}
