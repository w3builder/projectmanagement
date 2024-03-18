package com.project.management.services;

import java.util.List;

import com.project.management.domain.dto.ProjectDTO;

public interface ProjectService {
	List<ProjectDTO> findAll();
	List<ProjectDTO> findByNameLike(String name);
	ProjectDTO findById(Long id);
	ProjectDTO save(ProjectDTO project);
	void deleteById(Long id);
}
