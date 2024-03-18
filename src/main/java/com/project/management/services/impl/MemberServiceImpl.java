package com.project.management.services.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.project.management.domain.dto.MemberDTO;
import com.project.management.domain.dto.MemberIdDTO;
import com.project.management.domain.models.MemberId;
import com.project.management.domain.repositories.MemberRepository;
import com.project.management.exceptions.BusinessException;
import com.project.management.exceptions.ConflictException;
import com.project.management.exceptions.UnprocessableEntityException;
import com.project.management.helpers.Helper;
import com.project.management.mapper.MemberIdMapper;
import com.project.management.mapper.MemberMapper;
import com.project.management.services.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository repository;
	private final MemberMapper mapper;
	private final MemberIdMapper mapperId; 
	
	@Override
	public List<MemberDTO> findAll() {
		try {
			List<MemberDTO> listMembers = mapper.toListDTO(repository.findAll());
			if(listMembers.isEmpty()) {
				throw new UnprocessableEntityException(Helper.LIST_ALL_NOT_FOUND);
			}
			return listMembers;
			
		} catch (UnprocessableEntityException e) {
			throw new UnprocessableEntityException(e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("Erro ao listar todos os membros", e);
		}
	}

	@Override
	public MemberDTO findById(MemberIdDTO memberId) {
		try {
			MemberId id = mapperId.toEmbeded(memberId);
			MemberDTO member = mapper.toDTO(repository.findById(id).orElse(null));
			if(Objects.isNull(member)) {
				throw new UnprocessableEntityException(Helper.NOT_FOUND);
			}
			return member;
			
		} catch (UnprocessableEntityException e) {
			throw new UnprocessableEntityException(e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("Erro ao buscar membro", e);
		}
	}

	@Override
	public MemberDTO save(MemberDTO member) {
		try {
			if(repository.findById(mapperId.toEmbeded(member.getId())).isPresent()) {
				throw new ConflictException("Membro já cadastro ao projeto");
			}
			return mapper.toDTO(repository.save(mapper.toEntity(member)));
			
		} catch (ConflictException e) {
			throw new ConflictException(e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("Erro ao salvar membro", e);
		}
	}

	@Override
	public void deleteById(MemberIdDTO memberId) {
		try {
			repository.deleteById(mapperId.toEmbeded(memberId));
		} catch (Exception e) {
			throw new BusinessException("Erro ao tenter deletar o membro", e);
		}
	}
}
