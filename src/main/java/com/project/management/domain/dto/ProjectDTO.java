package com.project.management.domain.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.project.management.domain.enums.Risk;
import com.project.management.domain.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
	
	private Long id;
    private String name;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date startDate;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date expectedEndDate;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date endDate;
    
    private String description;
    private Status status;
    private Float budget;
    private Risk risk;
    private PersonDTO manager;
}
