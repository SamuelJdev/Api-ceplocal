package com.controle.kitnet.domain.model.service;

import com.controle.kitnet.domain.model.Endereco;
import com.controle.kitnet.infrastructure.exception.EntidadeNotFoundException;
import feign.FeignException;
import org.springframework.stereotype.Service;

@Service
public class KitnetImpl implements IKitnet {

    private final EnderecoPort enderecoPort;

    public KitnetImpl(EnderecoPort enderecoPort) {
        this.enderecoPort = enderecoPort;
    }

    @Override
    public Endereco getCep(String cep) throws Exception {
        try {
            Endereco endereco = enderecoPort.getCep(cep);
            return endereco;
        } catch (FeignException e) {
            throw new EntidadeNotFoundException("CEP " + cep+ " não encontrado" );
        }
    }
}
