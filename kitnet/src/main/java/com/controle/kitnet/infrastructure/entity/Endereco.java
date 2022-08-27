package com.controle.kitnet.infrastructure.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Endereco {

    private String cep;

    private String numero;

    private String logradouro;

    private String complemento;

    private String bairro;

}
