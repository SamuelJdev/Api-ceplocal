package com.controle.kitnet.domain.model.service;

import com.controle.kitnet.domain.model.Endereco;

public interface EnderecoPort {

     Endereco getCep(String cep);
}
