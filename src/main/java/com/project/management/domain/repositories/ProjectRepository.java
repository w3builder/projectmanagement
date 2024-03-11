package com.project.management.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.management.domain.models.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

	List<Project> findByNameLike(String name);
}
