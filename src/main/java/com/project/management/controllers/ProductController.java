package com.project.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.management.helpers.Helper;
import com.project.management.domain.dto.ProjectDTO;
import com.project.management.domain.enums.RiskLevel;
import com.project.management.domain.enums.Status;
import com.project.management.services.PersonService;
import com.project.management.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProductController {
	
	@Autowired
	private ProjectService service;
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/search")
	public String findByName(Model model, @RequestParam("name") String name) {
		List<ProjectDTO> projectList = service.findByNameLike(name);
		model.addAttribute("projects", projectList);
		model.addAttribute("displayAlert", "none");
		
		if(projectList.isEmpty()) {
			model.addAttribute("displayAlert", "block");
			model.addAttribute("message", Helper.EMPTY_SEARCH);
			return "index";
		}
		
		return "index";
	}
	
	@GetMapping("/new")
	public String create(Model model) {
		
		model.addAttribute("risk", RiskLevel.values());
		model.addAttribute("status", Status.values());
		model.addAttribute("personList", personService.findByManager(Boolean.TRUE));
		
		return "create";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute ProjectDTO project) {
		service.save(project);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edite(Model model, @PathVariable("id") Long id) {
		
		model.addAttribute("project", service.findById(id));
		model.addAttribute("risk", RiskLevel.values());
		model.addAttribute("status", Status.values());
		model.addAttribute("personList", personService.findByManager(Boolean.TRUE));
		
		return "edit";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute ProjectDTO project) {
		service.save(project);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable("id") Long id) {

		ProjectDTO project = service.findById(id);
		
		if (project != null && Helper.isStatusNotDelete(project)) {
			model.addAttribute("displayAlert", "block");
			model.addAttribute("message", String.format(Helper.NOT_DELETE_WITH_STATUS,
					project.getStatus().getDescription()));
		} else {
			model.addAttribute("displayAlert", "none");
			service.deleteById(id);
		}

		model.addAttribute("projects", service.findAll());
		return "index";
	}
}
