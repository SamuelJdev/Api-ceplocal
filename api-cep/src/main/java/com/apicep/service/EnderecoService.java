package com.apicep.service;

import java.io.Serializable;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicep.model.Endereco;
import com.apicep.repository.EnderecoRepository;

@Service
public class EnderecoService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private final EnderecoRepository enderecoRepository;
	
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}
	
	@Transactional
	public Endereco salvar(Endereco endereco) throws Exception{
		Optional<Endereco> enderecoCep = enderecoRepository.buscarCep(endereco.getCep());
		if(enderecoCep.isPresent()) {
			throw new Exception("Cep ja existente, favor informar outro");
		}
		return enderecoRepository.save(endereco);
	}
	
	@Transactional
	public Endereco atualizar(Endereco endereco, String cep) throws Exception {
		Optional<Endereco> enderecoCep = enderecoRepository.buscarCep(cep);
		if (enderecoCep.isEmpty()) {
			throw new Exception("O Cep não foi encontrado");

		} else {
			Endereco enderecoNovo = enderecoCep.get();
			BeanUtils.copyProperties(endereco, enderecoNovo, "cep");

			return enderecoRepository.save(enderecoNovo); //
		}
	}
	
	public Endereco findBydCep(String cep) throws Exception	{
		Optional<Endereco> enderecoOptional = enderecoRepository.buscarCep(cep);
		if (enderecoOptional.isEmpty()) {
			throw new Exception("Cep não encontrado");
		} 
		Endereco e = enderecoOptional.get();
		return e;
	}
	
}