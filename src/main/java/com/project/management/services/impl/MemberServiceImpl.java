package com.project.management.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.management.domain.dto.MemberDTO;
import com.project.management.domain.dto.MemberIdDTO;
import com.project.management.domain.models.Member;
import com.project.management.domain.models.MemberId;
import com.project.management.domain.repositories.MemberRepository;
import com.project.management.services.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<MemberDTO> findAll() {
		return repository.findAll().stream()
				.map(member -> mapper.map(member, MemberDTO.class))
		        .collect(Collectors.toList());
	}

	@Override
	public MemberDTO save(MemberDTO member) {
		return mapper.map(repository.save(mapper.map(member, Member.class)), MemberDTO.class);
	}

	@Override
	public MemberDTO findById(MemberIdDTO memberId) {
		MemberId mId = mapper.map(memberId, MemberId.class);
		return mapper.map(repository.findById(mId), MemberDTO.class);
	}

	@Override
	public void deleteById(MemberIdDTO memberId) {
		repository.deleteById(mapper.map(memberId, MemberId.class));
	}
}
