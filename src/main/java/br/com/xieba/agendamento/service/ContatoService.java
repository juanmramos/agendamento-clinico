package br.com.xieba.agendamento.service;

import br.com.xieba.agendamento.dto.ContatoDTO;
import br.com.xieba.agendamento.entity.ContatoEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    @Autowired
    private ModelMapper modelMapper;

    public ContatoDTO toContatoDto(ContatoEntity contatoEntity) {
        return modelMapper.map(contatoEntity, ContatoDTO.class);
    }

    public ContatoEntity toContatoEntity(ContatoDTO contatoDTO) {
        return modelMapper.map(contatoDTO, ContatoEntity.class);
    }
}
