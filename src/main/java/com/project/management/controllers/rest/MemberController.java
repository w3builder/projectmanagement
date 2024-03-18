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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
@Api(tags="member-api")
public class MemberController {

	private final MemberService service;
	
	@GetMapping
	@ApiOperation(value = "findAll", notes = "Carrega todos os membros associados a um projeto", httpMethod = "GET")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista carregada com sucesso!"),
            @ApiResponse(code = 500, message = "Erro ao carregar lista!")
    })
	public ResponseEntity<List<MemberDTO>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("/{idProject}/{idPerson}")
	@ApiOperation(value = "findById", notes = "Busca um membro usando id composto idPessoa, idProjeto", httpMethod = "GET")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Membro encontradoo com sucesso!"),
            @ApiResponse(code = 500, message = "Erro ao realizar a busca!")
    })
	public ResponseEntity<MemberDTO> findById(@PathVariable("idProject") Long idProject, 
			@PathVariable("idPerson") Long idPerson) {
			MemberIdDTO memberId = new MemberIdDTO(idProject, idPerson);
		return ResponseEntity.ok(service.findById(memberId));
	}
	
	@PostMapping
	@ApiOperation(value = "save", notes ="Cria um novo membro associando-o a um projeto", httpMethod = "POST")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Novo mebro criado com sucesso!"),
            @ApiResponse(code = 500, message = "Erro ao criar um novo membro!")
    })
	public ResponseEntity<MemberDTO> save(@RequestBody MemberDTO member) {
		return ResponseEntity.ok(service.save(member));
	}
	
	@PutMapping
	@ApiOperation(value = "update", notes ="Atualiza um membro associando-o a um projeto", httpMethod = "PUT")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualização realizada com sucesso!"),
            @ApiResponse(code = 500, message = "Erro ao ataulizar cadastro!")
    })
	public ResponseEntity<MemberDTO> update(@RequestBody MemberDTO member) {
		return ResponseEntity.ok(service.update(member));
	}
	
	@DeleteMapping("/delete/{idProject}/{idPerson}")
	@ApiOperation(value = "delete", notes = "Deleta um membro usando id composto idPessoa, idProjeto", httpMethod = "GET")
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Membro deletado com sucesso!"),
            @ApiResponse(code = 500, message = "Erro ao tentar deletar o regiistro!")
    })
	public void delete(@PathVariable("idProject") Long idProject, 
			@PathVariable("idPerson") Long idPerson) {
		service.deleteById(new MemberIdDTO(idProject, idPerson));
	}
}
