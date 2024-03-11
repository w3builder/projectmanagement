package com.project.management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.management.services.ProjectService;

@Controller
public class IndexController {

	@Autowired
	private ProjectService service;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		model.addAttribute("displayAlert", "none");
		model.addAttribute("projects", service.findAll());
		return "index";
	}
}
