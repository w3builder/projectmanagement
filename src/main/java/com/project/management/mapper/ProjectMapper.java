package com.project.management.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.project.management.domain.dto.ProjectDTO;
import com.project.management.domain.models.Project;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProjectMapper {

	private final ModelMapper mapper;
	
	public Project toEntity(ProjectDTO dto) {
		return mapper.map(dto, Project.class);
	}
	
	public ProjectDTO toDTO(Project entity) {
		return mapper.map(entity, ProjectDTO.class);
	}
	
	public List<ProjectDTO> toListDTO(List<Project> listEntity){
		return listEntity.stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	public List<Project> toListEntity(List<ProjectDTO> listDTO){
		return listDTO.stream().map(this::toEntity).collect(Collectors.toList());
	}
}
