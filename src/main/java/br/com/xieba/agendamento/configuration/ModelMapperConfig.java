package br.com.xieba.agendamento.configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        //modelMapper.createTypeMap(ContatoEntity.class, ContatoDTO.class);

        return modelMapper;
    }
}
