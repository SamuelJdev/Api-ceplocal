package com.controle.kitnet.domain.model.service;

import com.controle.kitnet.domain.model.Endereco;

public interface IKitnet {

    Endereco getCep(String cep) throws Exception;

}
