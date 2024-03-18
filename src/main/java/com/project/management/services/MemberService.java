package com.project.management.services;

import java.util.List;

import com.project.management.domain.dto.MemberDTO;
import com.project.management.domain.dto.MemberIdDTO;

public interface MemberService {

	List<MemberDTO> findAll();
	MemberDTO save(MemberDTO member);
	MemberDTO update(MemberDTO member);
	MemberDTO findById(MemberIdDTO id);
	void deleteById(MemberIdDTO id);
}
