package com.controle.kitnet.api.v1.controller;

import com.controle.kitnet.api.v1.converter.EnderecoDTOMapper;
import com.controle.kitnet.api.v1.dto.EnderecoDTO;
import com.controle.kitnet.domain.model.Endereco;
import com.controle.kitnet.domain.model.service.IKitnet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/inquilinos")
public class InquilinoController {

    @Autowired
    private IKitnet iKitnet;

    @Autowired
    private EnderecoDTOMapper enderecoDTOMapper;

    @GetMapping("/{cep}")
    public ResponseEntity<EnderecoDTO> getCep(@PathVariable("cep") String cep) throws Exception {
         Endereco endereco = iKitnet.getCep(cep);
         return ResponseEntity.ok().body(enderecoDTOMapper.toEnderecoDTO(endereco));
    }
}
