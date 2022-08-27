package com.controle.kitnet.api.v1.dto;

import lombok.Data;

@Data
public class EnderecoDTO {

    private Long id;

    private String cep;

    private String numero;

    private String lagradouro;

    private String complemento;

}
