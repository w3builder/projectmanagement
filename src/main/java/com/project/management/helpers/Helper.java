package com.project.management.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.lang.String.format;

import org.springframework.ui.Model;

import com.project.management.domain.dto.PersonDTO;
import com.project.management.domain.dto.ProjectDTO;
import com.project.management.domain.enums.Risk;
import com.project.management.domain.enums.Status;
import com.project.management.domain.models.Project;

public class Helper {
	
	private Helper() {}
	
	public static final String LIST_ALL_NOT_FOUND = "Não há registros cadastrados!";
	public static final String NOT_FOUND = "A busca por id não retornou resultado!";
	public static final String EMPTY_SEARCH = "A consulta não retornou resultados";
	public static final String NOT_DELETE_WITH_STATUS = "Não é permitido excluir um projeto com o status: %s";
	public static final String DISPLAY_ALERT = "displayAlert";
	public static final String REDIRECT_URL = "redirect:/";
	
	public static String prepareIndexView(Model model, List<ProjectDTO> listProjects) {
		
		model.addAttribute("projects", listProjects);
		model.addAttribute(DISPLAY_ALERT, "none");
		
		if(listProjects.isEmpty()) {
			model.addAttribute(DISPLAY_ALERT, "block");
			model.addAttribute("message", EMPTY_SEARCH);
		}
		
		return "index";
	}
	
	public static String prepareCreateView(Model model, List<PersonDTO> listManager) {
		model.addAttribute("risk", Risk.values());
		model.addAttribute("status", Status.values());
		model.addAttribute("personList", listManager);
		return "create";
	}
	
	public static String prepareEditView(Model model, List<PersonDTO> listManager, ProjectDTO project) {
		model.addAttribute("project", project);
		model.addAttribute("risk", Risk.values());
		model.addAttribute("status", Status.values());
		model.addAttribute("personList", listManager);
		return "edit";
	}
	
	public static String prepareDeleteErrorView(Model model, List<ProjectDTO> listProjects, ProjectDTO project, String message) {
		
		model.addAttribute("projects", listProjects);
		model.addAttribute(DISPLAY_ALERT, "block");
		model.addAttribute("message", format(message, project.getStatus().getDescription()));
		
		return "index";
	}

	public static boolean isStatusNotDelete(Project project) {
		return project.getStatus().equals(Status.STARTED) || project.getStatus().equals(Status.IN_PROGRESS)
				|| project.getStatus().equals(Status.CLOSED);
	}
	
	public static boolean isInvalideDeadline(ProjectDTO project) {
		return project.getStartDate().after(project.getExpectedEndDate()) 
				|| project.getStartDate().after(project.getEndDate());
	}
	
	public static Date stringToDate(String dataString) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.parse(dataString);
    }
}
