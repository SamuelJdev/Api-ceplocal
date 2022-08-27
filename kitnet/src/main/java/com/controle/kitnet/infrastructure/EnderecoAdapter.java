package com.controle.kitnet.infrastructure;

import com.controle.kitnet.domain.model.Endereco;
import com.controle.kitnet.domain.model.service.EnderecoPort;
import com.controle.kitnet.infrastructure.client.CepClient;
import org.springframework.stereotype.Service;

@Service
public class EnderecoAdapter implements EnderecoPort {

    private final CepClient cepClient;

    public EnderecoAdapter(CepClient cepClient) {
        this.cepClient = cepClient;
    }

    @Override
    public  Endereco getCep(String cep) {
        Endereco endereco = cepClient.getCep(cep);
        return endereco;
    }
}
