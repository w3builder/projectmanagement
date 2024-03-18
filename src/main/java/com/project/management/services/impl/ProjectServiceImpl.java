package com.project.management.services.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.project.management.domain.dto.ProjectDTO;
import com.project.management.domain.models.Project;
import com.project.management.domain.repositories.ProjectRepository;
import com.project.management.exceptions.BusinessException;
import com.project.management.exceptions.ConflictException;
import com.project.management.exceptions.UnprocessableEntityException;
import com.project.management.helpers.Helper;
import com.project.management.mapper.ProjectMapper;
import com.project.management.services.ProjectService;

import lombok.RequiredArgsConstructor;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
	
	private final ProjectRepository repository;	
	private final ProjectMapper mapper;

	@Override
	public List<ProjectDTO> findAll() {
		try {
			List<ProjectDTO> listProjects = mapper.toListDTO(repository.findAll());
			if(listProjects.isEmpty()) {
				throw new UnprocessableEntityException(Helper.LIST_ALL_NOT_FOUND);
			}
			return listProjects;
			
		} catch (UnprocessableEntityException e) {
			throw new UnprocessableEntityException(e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("Erro ao listar todos os projetos", e);
		}
	}

	@Override
	public List<ProjectDTO> findByNameLike(String name) {
		try {
			String like = String.format("%%%s%%", name);

			List<ProjectDTO> listProjects = mapper.toListDTO(repository.findByNameLike(like));
			if(listProjects.isEmpty()) {
				throw new UnprocessableEntityException(Helper.NOT_FOUND);
			}
			return listProjects;
			
		} catch (UnprocessableEntityException e) {
			throw new UnprocessableEntityException(e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("Erro ao buscar projetos nome", e);
		}
	}

	@Override
	public ProjectDTO findById(Long id) {
		try {
			ProjectDTO project = mapper.toDTO(repository.findById(id).orElse(null));
			if(Objects.isNull(project)) {
				throw new UnprocessableEntityException(Helper.NOT_FOUND);
			}
			
			return project;
			
		} catch (UnprocessableEntityException e) {
			throw new UnprocessableEntityException(e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("Erro ao buscar projeto por id", e);
		}
	}

	@Override
	public ProjectDTO save(ProjectDTO project) {
		try {
			Project projectSave = repository.save(mapper.toEntity(project));
			return mapper.toDTO(projectSave);
		} catch (Exception e) {
			throw new BusinessException("Erro ao salvar um novo projeto", e);
		}
	}

	@Override
	public void deleteById(Long id) {
		try {
			Project project = repository.findById(id)
					.orElseThrow(() -> new UnprocessableEntityException(Helper.NOT_FOUND));
			
			if(Helper.isStatusNotDelete(project)) {
				throw new ConflictException(format(Helper.NOT_DELETE_WITH_STATUS, project.getStatus().getDescription()));
			}
			
			repository.deleteById(project.getId());
			
		} catch (ConflictException e) {
			throw new UnprocessableEntityException(e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("Erro ao tenter deletar o projeto", e);
		}
	}

}
