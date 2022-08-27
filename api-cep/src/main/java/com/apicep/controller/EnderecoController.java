package com.apicep.controller;

import java.io.Serializable;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apicep.model.Endereco;
import com.apicep.service.EnderecoService;

@RestController
@RequestMapping(value = "enderecos", produces = MediaType.APPLICATION_JSON_VALUE)
public class EnderecoController implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping
	public Endereco salvar (@Valid @RequestBody Endereco endereco , HttpServletResponse response)throws Exception {
		enderecoService.salvar(endereco);
		return endereco;
	}
	
	@PutMapping("/cep/{cep}")
	public Endereco atualizar(@PathVariable String cep, @RequestBody Endereco endereco) throws Exception {
		Endereco enderecoAtualiza = enderecoService.atualizar(endereco, cep);
		return enderecoAtualiza;
	}
	
	@GetMapping("/{cep}")
	public Optional<Endereco> buscaCep(@PathVariable String cep) throws Exception{
	 	Optional<Endereco> enderecoOptional = Optional.ofNullable(enderecoService.findBydCep(cep));
	 	return enderecoOptional;
		
	}
}
