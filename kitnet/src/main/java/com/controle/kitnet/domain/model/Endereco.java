package com.controle.kitnet.domain.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
public class Endereco {

    private Long id;

    private String cep;

    private String numero;

    private String lagradouro;

    private String complemento;

}
