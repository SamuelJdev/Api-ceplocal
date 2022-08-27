package com.controle.kitnet.api.v1.dto;

import lombok.Data;

@Data
public class InquilinoDTO {

    private Long id;

    private String cpf;

    private String nome;

    private EnderecoDTO endereco;

}
