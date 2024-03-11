package com.project.management.domain.dto;

import com.project.management.domain.enums.Position;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private MemberIdDTO id;
    private ProjectDTO projeto;
    private PersonDTO pessoa;
    private String name;
    private Position position;
}
