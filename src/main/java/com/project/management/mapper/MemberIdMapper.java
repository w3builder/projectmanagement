package com.project.management.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.project.management.domain.dto.MemberIdDTO;
import com.project.management.domain.models.MemberId;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MemberIdMapper {

	private final ModelMapper mapper;
	
	public MemberId toEmbeded(MemberIdDTO dto) {
		return mapper.map(dto, MemberId.class);
	}
	
	public MemberIdDTO toDTO(MemberId embeded) {
		return mapper.map(embeded, MemberIdDTO.class);
	}
}
