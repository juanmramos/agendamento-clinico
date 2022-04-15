package br.com.xieba.agendamento.controller;

import br.com.xieba.agendamento.dto.ContatoDTO;
import br.com.xieba.agendamento.entity.ContatoEntity;
import br.com.xieba.agendamento.repository.ContatoRepository;
import br.com.xieba.agendamento.service.ContatoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "contato")
@Api(tags = {"ManterContatos"})
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ContatoService contatoService;

    @ApiOperation(value = "Realiza a busca do imovel pelo id.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok", response = String.class),
            @ApiResponse(code = 422, message = "Erro de validação nos campos", response = String.class),
            @ApiResponse(code = 500, message = "Erro interno do servidor", response = String.class) })
    @GetMapping(value = "/buscar/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id) throws Exception {

        ContatoEntity cantatoBanco = contatoRepository.findById(id).get();

        return new ResponseEntity<>(cantatoBanco, HttpStatus.OK);
    }

    @ApiOperation(value = "Realiza a busca do imovel pelo id.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok", response = String.class),
            @ApiResponse(code = 422, message = "Erro de validação nos campos", response = String.class),
            @ApiResponse(code = 500, message = "Erro interno do servidor", response = String.class) })
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<?> inserirContato(@RequestBody ContatoEntity contatoEntity) throws Exception {

        ContatoEntity contatoSalvo = contatoRepository.save(contatoEntity);

        return new ResponseEntity<>(contatoSalvo, HttpStatus.OK);
    }

    @ApiOperation(value = "Realiza a busca do imovel pelo id.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok", response = String.class),
            @ApiResponse(code = 422, message = "Erro de validação nos campos", response = String.class),
            @ApiResponse(code = 500, message = "Erro interno do servidor", response = String.class) })
    @DeleteMapping(value = "/excluir/{id}")
    public ResponseEntity<?> excluirContato(@PathVariable("id") Long id) throws Exception {

        ContatoEntity contatoEntity = contatoRepository.findById(id).get();
        contatoRepository.delete(contatoEntity);

        return new ResponseEntity<>("Excluido com sucesso!!!", HttpStatus.OK);
    }

    @ApiOperation(value = "Realiza a busca do imovel pelo id.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok", response = String.class),
            @ApiResponse(code = 422, message = "Erro de validação nos campos", response = String.class),
            @ApiResponse(code = 500, message = "Erro interno do servidor", response = String.class) })
    @PutMapping(value = "/atualizar")
    public ResponseEntity<?> atualizarContato(@RequestBody ContatoDTO contatoDTO) throws Exception {

        ContatoEntity buscaContato = contatoRepository.findById(contatoDTO.getId()).get();

        buscaContato = contatoService.toContatoEntity(contatoDTO);

        ContatoEntity contatoSalvo = contatoRepository.save(buscaContato);

        return new ResponseEntity<>(contatoService.toContatoDto(contatoSalvo), HttpStatus.OK);
    }
}
