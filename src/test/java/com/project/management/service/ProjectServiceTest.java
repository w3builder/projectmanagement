package com.project.management.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.project.management.domain.dto.ProjectDTO;
import com.project.management.domain.enums.Risk;
import com.project.management.domain.enums.Status;
import com.project.management.domain.models.Person;
import com.project.management.domain.models.Project;
import com.project.management.domain.repositories.ProjectRepository;
import com.project.management.services.impl.ProjectServiceImpl;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

	@InjectMocks
	ProjectServiceImpl service;

	@Mock
	ProjectRepository repository;

	@Mock
	ModelMapper mapper;

	Project project;
	
	Person gerente;
	
	@BeforeEach
	public void setUp() {
		
		gerente = new Person(1L, "John Doe", new Date(), "123.456.789-10", true, true);
		
		project = new Project(1L, "Projeto A", new Date(), 
				new Date(), null, "Um novo projeto A", 
				Status.STARTED, 10000.0f, Risk.LOW_RISK, gerente);

		when(repository.findById(project.getId())).thenReturn(Optional.of(project));
		when(repository.findAll()).thenReturn(Collections.singletonList(project));
	}
	
	@Test
    void testCreateProject() {
		
		Person gerente = new Person(1L, "João Pedro", new Date(), "123.456.789-10", true, true);
		
		Project projectNew = new Project(2L, "Criação de um projeto", new Date(), 
				new Date(), null, "Um novo projeto", 
				Status.STARTED, 10000.0f, Risk.LOW_RISK, gerente);
		
		when(repository.save(projectNew)).thenReturn(projectNew);

        ProjectDTO saveProject = service.save(mapper.map(projectNew, ProjectDTO.class));
        
        assertEquals(mapper.map(projectNew, ProjectDTO.class), saveProject);
        verifyNoMoreInteractions(repository);
    }
	
	@Test
    void testUpdateProject() {
		
		project.setName("Auteração de um projeto");

        ProjectDTO saveProject = service.save(mapper.map(project, ProjectDTO.class));
        
        assertEquals(mapper.map(project, ProjectDTO.class), saveProject);
        verifyNoMoreInteractions(repository);
    }
	
	@Test
	void findAllProject() {
		
		List<Project> retrievedProjects = repository.findAll();

        assertEquals(1, retrievedProjects.size());
        assertEquals(project, retrievedProjects.get(0));
	}
	
	@Test
	void findProjectById() {
		
		ProjectDTO dto = mapper.map(service.findById(project.getId()), ProjectDTO.class);
		
		assertEquals(dto, mapper.map(project, ProjectDTO.class));
		verifyNoMoreInteractions(repository);
	}

}

