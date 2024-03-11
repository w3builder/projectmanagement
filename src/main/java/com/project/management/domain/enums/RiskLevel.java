package com.project.management.domain.enums;

public enum RiskLevel {
	
	LOW_RISK(0, "Baixo Risco"), 
	MEDIUM_RISK(1, "Médio Risco"), 
	HIGH_RISK(2, "Alto Risco");

	private final Integer ordinal;
	private final String description;

	RiskLevel(Integer ordinal, String description) {
		this.ordinal = ordinal;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	public Integer getOrdinal() {
		return ordinal;		
	}
}
