package com.project.management.services;

import java.util.List;
import java.util.Optional;

import com.project.management.domain.dto.PersonDTO;

public interface PersonService {
	List<PersonDTO> findByManager(boolean manager);
}
