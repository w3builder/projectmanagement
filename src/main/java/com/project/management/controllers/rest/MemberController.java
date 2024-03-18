package com.project.management.controllers.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.management.domain.dto.MemberDTO;
import com.project.management.domain.dto.MemberIdDTO;
import com.project.management.services.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

	private final MemberService service;
	
	@GetMapping
	public ResponseEntity<List<MemberDTO>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{idProject}/{idPerson}")
	public ResponseEntity<MemberDTO> findById(@PathVariable("idProject") Long idProject, 
			@PathVariable("idPerson") Long idPerson) {
		
		MemberIdDTO memberId = new MemberIdDTO(idProject, idPerson);
		MemberDTO member =  service.findById(memberId);
		
		return ResponseEntity.ok(member);
	}
	
	@PostMapping
	public void save(@RequestBody MemberDTO member) {
		service.save(member);
	}
	
	@PutMapping
	public void update(@RequestBody MemberDTO member) {
		service.save(member);
	}
	
	@DeleteMapping("/delete/{idProject}/{idPerson}")
	public void delete(@PathVariable("idProject") Long idProject, 
			@PathVariable("idPerson") Long idPerson) {
		service.deleteById(new MemberIdDTO(idProject, idPerson));
	}
}
