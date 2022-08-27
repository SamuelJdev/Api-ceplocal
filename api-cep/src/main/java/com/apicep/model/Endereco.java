package com.apicep.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "endereco")
@Entity
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "cep", length = 10, unique = true)
	private String cep;
	
	@Column(name = "numero", length = 10)
	private String numero;
	
	@Column(name = "lagradouro", length = 100)
	private String lagradouro;
	
	@Column(name = "complemento", length = 100)
	private String complemento;

	public Endereco() {
	}
	
	public Endereco(Long id, String cep, String numero, String lagradouro, String complemento) {
		this.id = id;
		this.cep = cep;
		this.numero = numero;
		this.lagradouro = lagradouro;
		this.complemento = complemento;
	}

	
	
	@Override
	public String toString() {
		return "Enderecos [id=" + id + ", cep=" + cep + ", numero=" + numero + ", lagradouro=" + lagradouro
				+ ", complemento=" + complemento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(id, other.id);
	}
}