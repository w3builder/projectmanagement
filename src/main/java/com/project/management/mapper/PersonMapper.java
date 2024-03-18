package com.project.management.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.project.management.domain.dto.PersonDTO;
import com.project.management.domain.models.Person;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PersonMapper {

	private final ModelMapper mapper;
	
	public Person toEntity(PersonDTO dto) {
		return mapper.map(dto, Person.class);
	}
	
	public PersonDTO toDTO(Person entity) {
		return mapper.map(entity, PersonDTO.class);
	}
	
	public List<PersonDTO> toListDTO(List<Person> listEntity){
		return listEntity.stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	public List<Person> toListEntity(List<PersonDTO> listDTO){
		return listDTO.stream().map(this::toEntity).collect(Collectors.toList());
	}

}
