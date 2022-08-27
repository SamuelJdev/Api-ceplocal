package com.apicep.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apicep.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
	@Query("select e from Endereco e "
			+ "where e.cep = :cep")
	Optional<Endereco> buscarCep (@Param("cep") String cep);
}