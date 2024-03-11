package com.project.management.domain.enums;

public enum Position {
	
	MANAGER(0, "Gerente"), 
	EMPLOYEE(1, "Funcionário");

	private final Integer ordinal;
	private final String description;

	Position(Integer ordinal, String description) {
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
