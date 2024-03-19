package com.project.management.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.management.domain.dto.MemberDTO;
import com.project.management.domain.dto.MemberIdDTO;
import com.project.management.domain.enums.Position;
import com.project.management.services.MemberService;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {
	
	@Mock
	MemberService service;
	
	MemberIdDTO id;
	MemberDTO member;
	List<MemberDTO> listMembers;
	
	@BeforeEach
	void setup() {
		id = new MemberIdDTO(1L, 1L);
		member = new MemberDTO(id, "João", Position.EMPLOYEE);
		listMembers = Arrays.asList(member);
	}

	@Test
    void deveCriarMembrosComSucesso() {
		
		when(service.save(member)).thenReturn(member);
		
		MemberDTO memberSave = service.save(member);
		
		assertEquals(member, memberSave);
		verify(service).save(member);
		verifyNoMoreInteractions(service);
	}
	
	@Test
	void deveBuscarMembroPorIdComSucesso() {
		
		when(service.findById(id)).thenReturn(member);
		
		MemberDTO memberFind = service.findById(id);
		
		assertEquals(member, memberFind);
		verify(service).findById(id);
		verifyNoMoreInteractions(service);
	}
	
	@Test
	void deveBuscarTodosOsMembros() {
		
		when(service.findAll()).thenReturn(listMembers);
		List<MemberDTO> listMembersReturn = service.findAll();		
		
		assertEquals(listMembers, listMembersReturn);
		verify(service).findAll();
		verifyNoMoreInteractions(service);
	}
}
