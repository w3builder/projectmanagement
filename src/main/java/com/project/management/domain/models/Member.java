package com.project.management.domain.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.project.management.domain.enums.Position;

import lombok.Data;

@Data
@Entity
@Table(name = "MEMBROS")
public class Member {

    @EmbeddedId
    private MemberId id;

    @ManyToOne
    @JoinColumn(name = "IDPROJETO", referencedColumnName = "id", nullable = false)
    @MapsId("IDPROJETO")
    private Project projeto;

    @ManyToOne
    @JoinColumn(name = "IDPESSOA", referencedColumnName = "id", nullable = false)
    @MapsId("IDPESSOA")
    private Person pessoa;
    
    @Column(name = "NOME", length = 200)
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "CARGO", length = 200)
    private Position position;
}