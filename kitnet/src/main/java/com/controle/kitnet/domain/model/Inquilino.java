package com.controle.kitnet.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
public class Inquilino {

    private Long id;

    private String cpf;

    private String nome;

    private Endereco endereco;

}
