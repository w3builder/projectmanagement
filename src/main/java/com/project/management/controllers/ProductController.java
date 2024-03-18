package com.project.management.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.management.domain.dto.PersonDTO;
import com.project.management.domain.dto.ProjectDTO;
import com.project.management.helpers.Helper;
import com.project.management.services.PersonService;
import com.project.management.services.ProjectService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProductController {
	
	private final ProjectService service;
	
	private final PersonService personService;
	
	@GetMapping("/search")
	public String search(Model model, @RequestParam("name") String name) {
		List<ProjectDTO> listProjects = service.findByNameLike(name);
		return Helper.prepareIndexView(model, listProjects);
	}
	
	@GetMapping("/new")
	public String create(Model model) {
		List<PersonDTO> listManagers = personService.findByManager(Boolean.TRUE);
		return Helper.prepareCreateView(model, listManagers);
	}
	
	
	@GetMapping("/edit/{id}")
	public String edite(Model model, @PathVariable("id") Long id) {
		ProjectDTO project = service.findById(id);
		List<PersonDTO> listPersons = personService.findByManager(Boolean.TRUE);
		return Helper.prepareEditView(model, listPersons, project);
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute ProjectDTO project) {
		service.save(project);
		return Helper.REDIRECT_URL;
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable("id") Long id) {
		service.deleteById(id);
		return Helper.REDIRECT_URL;
	}
}
