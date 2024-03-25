package com.project.management.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.management.domain.dto.PersonDTO;
import com.project.management.domain.repositories.PersonRepository;
import com.project.management.exceptions.BusinessException;
import com.project.management.exceptions.UnprocessableEntityException;
import com.project.management.helpers.Helper;
import com.project.management.mapper.PersonMapper;
import com.project.management.services.PersonService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

	private final PersonRepository repository;
	private final PersonMapper mapper;

	@Override
	public List<PersonDTO> findByManager(boolean manager) {
		try {
			List<PersonDTO> listPersons = mapper.toListDTO(repository.findByManager(manager));
			if(listPersons.isEmpty()) {
				throw new UnprocessableEntityException(Helper.LIST_ALL_NOT_FOUND);
			}
			return listPersons;
		} catch (Exception e) {
			throw new BusinessException("Erro ao listar todos os gerentes", e);
		}
	}
}
