package com.project.management.service;

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

import com.project.management.domain.dto.PersonDTO;
import com.project.management.domain.models.Person;
import com.project.management.mapper.PersonMapper;
import com.project.management.services.PersonService;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
	
	@Mock
	PersonService service;

	@Mock
	PersonMapper mapper;
	
	@Test
	void deveBuscarTodosOsGerentes() {
		
		PersonDTO manager = mapper.toDTO( new Person(1L, "João", new Date(), "123.456.789-10", true, true));
		
		List<PersonDTO> listManager = Arrays.asList(manager);
		
		when(service.findByManager(Boolean.TRUE)).thenReturn(listManager);
		List<PersonDTO> listManagersReturn = service.findByManager(Boolean.TRUE);		
		
		assertEquals(listManager, listManagersReturn);
		verify(service).findByManager(Boolean.TRUE);
		verifyNoMoreInteractions(service);
	}
}
