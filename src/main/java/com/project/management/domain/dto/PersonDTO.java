package com.project.management.domain.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
	private Long id;
	private String name;
	private Date birthDate;
	private String cpf;
	private Boolean employee;
	private Boolean manager;
}
