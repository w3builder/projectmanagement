package com.project.management.domain.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.management.domain.enums.RiskLevel;
import com.project.management.domain.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Pessoa")
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME", nullable = false)
	private String name;

	@Column(name = "DATANASCIMENTO")
	private Date birthDate;

	@Column(name = "CPF", length = 14)
	private String cpf;

	@Column(name = "FUNCIONARIO")
	private Boolean employee;

	@Column(name = "GERENTE")
	private Boolean manager;

}
