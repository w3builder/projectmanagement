package com.project.management.domain.repositoty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.management.domain.models.Person;
import com.project.management.domain.repositories.PersonRepository;

@ExtendWith(MockitoExtension.class)
class PersonRepositoryTest {
	
	@Mock
	PersonRepository repository;

	@Test
	void deveBuscarTodosOsGerentes() {
		
		Person manager = new Person(1L, "João", new Date(), "123.456.789-10", true, true);
		
		List<Person> listManager = Arrays.asList(manager);
		
		when(repository.findByManager(Boolean.TRUE)).thenReturn(listManager);
		List<Person> listManagersReturn = repository.findByManager(Boolean.TRUE);		
		
		assertEquals(listManager, listManagersReturn);
		verify(repository).findByManager(Boolean.TRUE);
		verifyNoMoreInteractions(repository);
	}
}
