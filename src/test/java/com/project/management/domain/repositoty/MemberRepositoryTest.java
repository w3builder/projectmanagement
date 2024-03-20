package com.project.management.domain.repositoty;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.management.domain.enums.Position;
import com.project.management.domain.models.Member;
import com.project.management.domain.models.MemberId;
import com.project.management.domain.repositories.MemberRepository;
import com.project.management.exceptions.ConflictException;

@ExtendWith(MockitoExtension.class)
class MemberRepositoryTest {
	
	@Mock
	MemberRepository repository;

	MemberId id;
	Member member;
	List<Member> listMembers;
	
	@BeforeEach
	void setup() {
		id = new MemberId(1L, 1L);
		member = new Member(id, "João", Position.EMPLOYEE);
		listMembers = Arrays.asList(member);
	}

	@Test
    void deveCriarMembrosComSucesso() {
		
		when(repository.save(member)).thenReturn(member);
		
		Member memberSave = repository.save(member);
		
		assertEquals(member, memberSave);
		verify(repository).save(member);
		verifyNoMoreInteractions(repository);
	}
	
	@Test
	void deveRetornarExceptionQuandoOMembroExiste() {
		
		doThrow(new ConflictException("Membro já cadastro ao projeto")).when(repository).save(member);
		
		assertThrows(ConflictException.class, ()-> {
			repository.save(member);
		});		
		
		verify(repository).save(member);
		verifyNoMoreInteractions(repository);
	}
	
	@Test
	void deveBuscarMembroPorIdComSucesso() {
		
		when(repository.findById(id)).thenReturn(Optional.of(member));
		
		Member memberFind = repository.findById(id).get();
		
		assertEquals(member, memberFind);
		verify(repository).findById(id);
		verifyNoMoreInteractions(repository);
	}
	
	@Test
	void deveBuscarTodosOsMembros() {
		
		when(repository.findAll()).thenReturn(listMembers);
		List<Member> listMembersReturn = repository.findAll();		
		
		assertEquals(listMembers, listMembersReturn);
		verify(repository).findAll();
		verifyNoMoreInteractions(repository);
	}
	
	@Test
	void deveDeletarMembroPorId() {
		
		doNothing().when(repository).deleteById(member.getId());
		
		repository.deleteById(member.getId());
		
		verify(repository).deleteById(member.getId());
		verifyNoMoreInteractions(repository);
	}
	
}
