package com.project.management.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.management.domain.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	List<Person> findByManager(boolean manager);
}
