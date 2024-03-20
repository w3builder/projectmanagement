package com.project.management.domain.repositoty;

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
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.management.domain.enums.Risk;
import com.project.management.domain.enums.Status;
import com.project.management.domain.models.Person;
import com.project.management.domain.models.Project;
import com.project.management.domain.repositories.ProjectRepository;
import com.project.management.helpers.Helper;

@ExtendWith(MockitoExtension.class)
class ProjectRepositotyTest {
	
	@Mock
	ProjectRepository repository;

	Person manager;
	Project project;
	List<Project> listProjects;
	
	@BeforeEach
	void setup() {
		manager = new Person(1L, "João", new Date(), "123.456.789-10", true, true);
		project = new Project(1L, "Projeto A", new Date(), new Date(), null,
				"Um novo projeto A", Status.STARTED, 10000.0f, Risk.LOW_RISK, manager);
		
		listProjects = Arrays.asList(project);
	}
	
	@Test
    void deveCriarAtualizarProjetoComSucesso() {
		
		when(repository.save(project)).thenReturn(project);
		
		Project projectSave = repository.save(project);
		
		assertEquals(project, projectSave);
		verify(repository).save(project);
		verifyNoMoreInteractions(repository);
	}
	
	@Test
	void deveBuscarProjetoPorIdComSucesso() {
		
		when(repository.findById(project.getId())).thenReturn(Optional.of(project));
		Project projectSave = repository.findById(project.getId()).get();		
		
		assertEquals(project, projectSave);
		verify(repository).findById(1L);
		verifyNoMoreInteractions(repository);
	}
	
	@Test
	void deveBuscarProjetosPorNome() {
		
		when(repository.findByNameLike("Projeto")).thenReturn(listProjects);
		List<Project> listProjectsReturn = repository.findByNameLike("Projeto");		
		
		assertEquals(listProjects, listProjectsReturn);
		verify(repository).findByNameLike("Projeto");
		verifyNoMoreInteractions(repository);
	}
	
	@Test
	void deveBuscarTodosOsProjetos() {
		
		when(repository.findAll()).thenReturn(listProjects);
		List<Project> listProjectsReturn = repository.findAll();		
		
		assertEquals(listProjects, listProjectsReturn);
		verify(repository).findAll();
		verifyNoMoreInteractions(repository);
	}
	
	@Test
	void deveDeletarProjetoPorId() {
		
		doNothing().when(repository).deleteById(project.getId());
		
		repository.deleteById(project.getId());
		
		verify(repository).deleteById(project.getId());
		verifyNoMoreInteractions(repository);
	}
	
	@Test
	void deveRetornarExceptionAoDeletarComStatusNaoPermitido() {
		
		doThrow(new RuntimeException(Helper.NOT_DELETE_WITH_STATUS)).when(repository).deleteById(project.getId());
		
		assertThrows(RuntimeException.class, ()-> {
			repository.deleteById(project.getId());
		});		
		
		verify(repository).deleteById(project.getId());
		verifyNoMoreInteractions(repository);
	}
}
