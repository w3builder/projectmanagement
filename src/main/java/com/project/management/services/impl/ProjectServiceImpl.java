package com.project.management.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.management.domain.dto.ProjectDTO;
import com.project.management.domain.models.Project;
import com.project.management.domain.repositories.ProjectRepository;
import com.project.management.services.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<ProjectDTO> findAll() {
		return repository.findAll().stream()
				.map(project -> mapper.map(project, ProjectDTO.class))
		        .collect(Collectors.toList());
	}

	@Override
	public List<ProjectDTO> findByNameLike(String name) {
		return repository.findByNameLike(String.format("%%%s%%", name)).stream()
				.map(project -> mapper.map(project, ProjectDTO.class))
		        .collect(Collectors.toList());
	}

	@Override
	public ProjectDTO findById(Long id) {
		Project project = repository.findById(id).orElse(null);
		return mapper.map(project, ProjectDTO.class);
	}

	@Override
	public ProjectDTO save(ProjectDTO project) {
		return mapper.map(repository.save(mapper.map(project, Project.class)), ProjectDTO.class);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
