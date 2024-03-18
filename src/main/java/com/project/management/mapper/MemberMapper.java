package com.project.management.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.project.management.domain.dto.MemberDTO;
import com.project.management.domain.models.Member;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MemberMapper {

	private final ModelMapper mapper;
	
	public Member toEntity(MemberDTO dto) {
		return mapper.map(dto, Member.class);
	}
	
	public MemberDTO toDTO(Member entity) {
		return mapper.map(entity, MemberDTO.class);
	}
	
	public List<MemberDTO> toListDTO(List<Member> listEntity){
		return listEntity.stream().map(this::toDTO).collect(Collectors.toList());
	}
	
	public List<Member> toListEntity(List<MemberDTO> listDTO){
		return listDTO.stream().map(this::toEntity).collect(Collectors.toList());
	}
}
