package br.com.xieba.agendamento.service;

import br.com.xieba.agendamento.dto.ContatoDTO;
import br.com.xieba.agendamento.entity.ContatoEntity;
import br.com.xieba.agendamento.repository.ContatoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ContatoDTO toContatoDto(ContatoEntity contatoEntity) {
        return modelMapper.map(contatoEntity, ContatoDTO.class);
    }

    public ContatoEntity toContatoEntity(ContatoDTO contatoDTO) {
        return modelMapper.map(contatoDTO, ContatoEntity.class);
    }

    public List<ContatoEntity> regraIdadeMaior25() {

        List<ContatoEntity> contatoEntityList = contatoRepository.buscarContatoIdadeMaior25();

        return contatoEntityList;
    }
}
