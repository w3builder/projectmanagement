package com.project.management.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.management.domain.dto.PersonDTO;
import com.project.management.domain.repositories.PersonRepository;
import com.project.management.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<PersonDTO> findByManager(boolean manager) {
		return repository.findByManager(manager).stream().map(person -> mapper.map(person, PersonDTO.class))
				.collect(Collectors.toList());
	}
}
