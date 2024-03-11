package com.project.management.domain.enums;

public enum Status {
	
	UNDER_ANALYSIS("Em análise"),
	ANALYSIS_COMPLETED("Análise realizada"),
	ANALYSIS_APPROVED("Análise aprovada"),
	STARTED("Iniciado"),
	PLANNED("Planejado"),
	IN_PROGRESS("Em andamento"),
	CLOSED("Encerrado"),
	CANCELED("Cancelado");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
