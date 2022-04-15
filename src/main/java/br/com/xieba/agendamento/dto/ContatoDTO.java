package br.com.xieba.agendamento.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String identidade;
    private int idade;

}
