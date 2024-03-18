package com.project.management.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.management.domain.dto.ProjectDTO;
import com.project.management.domain.models.Project;
import com.project.management.domain.repositories.ProjectRepository;
import com.project.management.mapper.ProjectMapper;
import com.project.management.services.ProjectService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
	
	private final ProjectRepository repository;	
	private final ProjectMapper mapper;

	@Override
	public List<ProjectDTO> findAll() {
		return mapper.toListDTO(repository.findAll());
	}

	@Override
	public List<ProjectDTO> findByNameLike(String name) {
		String like = String.format("%%%s%%", name);
		return mapper.toListDTO(repository.findByNameLike(like));
	}

	@Override
	public ProjectDTO findById(Long id) {
		Project project = repository.findById(id).orElse(null);
		return mapper.toDTO(project);
	}

	@Override
	public ProjectDTO save(ProjectDTO project) {
		Project projectSave = repository.save(mapper.toEntity(project));
		return mapper.toDTO(projectSave);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
