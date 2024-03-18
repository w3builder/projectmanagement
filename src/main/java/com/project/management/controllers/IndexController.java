package com.project.management.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.management.domain.dto.ProjectDTO;
import com.project.management.helpers.Helper;
import com.project.management.services.ProjectService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {

	private final ProjectService service;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		List<ProjectDTO> listProjects = service.findAll();
		return Helper.prepareIndexView(model, listProjects);
	}
}
