package com.project.management.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.management.domain.dto.MemberDTO;
import com.project.management.domain.dto.MemberIdDTO;
import com.project.management.domain.enums.Position;
import com.project.management.domain.models.Member;
import com.project.management.domain.models.MemberId;
import com.project.management.mapper.MemberIdMapper;
import com.project.management.mapper.MemberMapper;
import com.project.management.services.MemberService;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {
	
	@Mock
	MemberService service;

	@Mock
	MemberMapper mapper;
	
	@Mock
	MemberIdMapper idMapper;
	
	@Test
    void deveCriarMembrosComSucesso() {
		
		MemberId id = new MemberId(1L, 1L);
		MemberDTO member = mapper.toDTO(new Member(id, "João", Position.EMPLOYEE));
		
		when(service.save(member)).thenReturn(member);
		
		MemberDTO memberSave = service.save(member);
		
		assertEquals(member, memberSave);
		verify(service).save(member);
		verifyNoMoreInteractions(service);
	}
	
	@Test
	void deveBuscarMembroPorIdComSucesso() {
		
		MemberId id = new MemberId(1L, 1L);
		MemberDTO member = mapper.toDTO(new Member(id, "João", Position.EMPLOYEE));
		
		MemberIdDTO idDTO = idMapper.toDTO(id);
		when(service.findById(idDTO)).thenReturn(member);
		
		MemberDTO memberFind = service.findById(idDTO);
		
		assertEquals(member, memberFind);
		verify(service).findById(idDTO);
		verifyNoMoreInteractions(service);
	}
	
	@Test
	void deveBuscarTodosOsMembros() {
		MemberId id = new MemberId(1L, 1L);
		MemberDTO member = mapper.toDTO(new Member(id, "João", Position.EMPLOYEE));
		
		List<MemberDTO> listMembers = Arrays.asList(member);
		
		when(service.findAll()).thenReturn(listMembers);
		List<MemberDTO> listMembersReturn = service.findAll();		
		
		assertEquals(listMembers, listMembersReturn);
		verify(service).findAll();
		verifyNoMoreInteractions(service);
	}
}
