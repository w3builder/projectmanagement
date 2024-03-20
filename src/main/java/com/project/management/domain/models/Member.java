package com.project.management.domain.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.project.management.domain.enums.Position;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MEMBROS")
public class Member {

    @EmbeddedId
    private MemberId id;
    
    @Column(name = "NOME", length = 200)
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "CARGO", length = 200)
    private Position position;
}