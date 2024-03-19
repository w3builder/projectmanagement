package com.project.management.domain.models;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class MemberId implements Serializable {

    private static final long serialVersionUID = 1L;
    
	private Long idprojeto;
    private Long idpessoa;
}
