package com.controle.kitnet.api.v1.converter;

import com.controle.kitnet.api.v1.dto.EnderecoDTO;
import com.controle.kitnet.domain.model.Endereco;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EnderecoDTOMapper {

    private ModelMapper modelMapper = new ModelMapper();

    public EnderecoDTO toEnderecoDTO(Endereco endereco){
        return  modelMapper.map(endereco, EnderecoDTO.class);
    }

}
