package com.project.management.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.management.domain.dto.PersonDTO;
import com.project.management.domain.dto.ProjectDTO;
import com.project.management.domain.enums.Risk;
import com.project.management.domain.enums.Status;
import com.project.management.domain.repositories.ProjectRepository;
import com.project.management.exceptions.ConflictException;
import com.project.management.helpers.Helper;
import com.project.management.mapper.ProjectMapper;
import com.project.management.services.ProjectService;

@ExtendWith(MockitoExtension.class)
class ProjectServiceTest {

	@Mock
	ProjectService service;

	@Mock
	ProjectRepository repository;

	@Mock
	ProjectMapper mapper;
	
	PersonDTO manager;
	ProjectDTO project;
	List<ProjectDTO> listProjects;
	
	@BeforeEach
	void setup() {
		manager = new PersonDTO(1L, "João", new Date(), "123.456.789-10", true, true);
		project = new ProjectDTO(1L, "Projeto A", new Date(), new Date(), null,
				"Um novo projeto A", Status.STARTED, 10000.0f, Risk.LOW_RISK, manager);
		
		listProjects = Arrays.asList(project);
	}
	
	@Test
    void deveCriarAtualizarProjetoComSucesso() {
		
		when(service.save(project)).thenReturn(project);
		
		ProjectDTO projectSave = service.save(project);
		
		assertEquals(project, projectSave);
		verify(service).save(project);
		verifyNoMoreInteractions(service);
	}
	
	@Test
	void deveBuscarProjetoPorIdComSucesso() {
		
		when(service.findById(project.getId())).thenReturn(project);
		ProjectDTO projectSave = service.findById(project.getId());		
		
		assertEquals(project, projectSave);
		verify(service).findById(1L);
		verifyNoMoreInteractions(service);
	}
	
	@Test
	void deveBuscarProjetosPorNome() {
		
		when(service.findByNameLike("Projeto")).thenReturn(listProjects);
		List<ProjectDTO> listProjectsReturn = service.findByNameLike("Projeto");		
		
		assertEquals(listProjects, listProjectsReturn);
		verify(service).findByNameLike("Projeto");
		verifyNoMoreInteractions(service);
	}
	
	@Test
	void deveBuscarTodosOsProjetos() {
		
		when(service.findAll()).thenReturn(listProjects);
		List<ProjectDTO> listProjectsReturn = service.findAll();		
		
		assertEquals(listProjects, listProjectsReturn);
		verify(service).findAll();
		verifyNoMoreInteractions(service);
	}
	
	@Test
	void deveDeletarProjetoPorId() {
		
		doNothing().when(service).deleteById(project.getId());
		
		service.deleteById(project.getId());
		
		verify(service).deleteById(project.getId());
		verifyNoMoreInteractions(service);
	}
	
	@Test
	void deveRetornarExceptionAoDeletarComStatusNaoPermitido() {
		
		doThrow(new ConflictException(Helper.NOT_DELETE_WITH_STATUS)).when(service).deleteById(project.getId());
		
		assertThrows(ConflictException.class, ()-> {
			service.deleteById(project.getId());
		});		
		
		verify(service).deleteById(project.getId());
		verifyNoMoreInteractions(service);
	}
}

