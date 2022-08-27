package com.controle.kitnet.infrastructure.client;

import com.controle.kitnet.domain.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.core.MediaType;

@FeignClient(url = "192.168.0.14:8081/enderecos", name = "enderecos")
public interface CepClient {

    @GetMapping(value = "/{cep}", consumes = MediaType.APPLICATION_JSON)
     Endereco getCep(@PathVariable("cep") String cep);

}
