package com.project.management.helpers;

import com.project.management.domain.dto.ProjectDTO;
import com.project.management.domain.enums.Status;

public class Helper {
	
	public static final String EMPTY_SEARCH = "A consulta não retornou nenhum resultado!";
	public static final String NOT_DELETE_WITH_STATUS = "Não é permitido excluir um projeto com o status: %s";

	public static boolean isStatusNotDelete(ProjectDTO project) {
		if(project.getStatus().equals(Status.STARTED) || project.getStatus().equals(Status.IN_PROGRESS)
				|| project.getStatus().equals(Status.CLOSED)) {
			return true;
		} 
		return false;
	}
	
	public static boolean isInvalideDeadline(ProjectDTO project) {
		if(project.getStartDate().after(project.getExpectedEndDate()) 
				|| project.getStartDate().after(project.getEndDate())){
				
			return true;
		}
		return false;
	}
}
