package com.project.management.domain.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.project.management.domain.enums.Risk;
import com.project.management.domain.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "PROJETO")
@AllArgsConstructor
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME", nullable = false, length = 200)
    private String name;

    @Column(name = "DATA_INICIO")
    private Date startDate;

    @Column(name = "DATA_PREVISAO_FIM")
    private Date expectedEndDate;

    @Column(name = "DATA_FIM")
    private Date endDate;

    @Column(name = "DESCRICAO", length = 5000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 45)
    private Status status;

    @Column(name = "ORCAMENTO")
    private Float budget;

    @Enumerated(EnumType.STRING)
    @Column(name = "RISCO", length = 45)
    private Risk risk;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDGERENTE", referencedColumnName = "id", nullable = false)
    private Person manager;
}
