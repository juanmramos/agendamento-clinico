package br.com.xieba.agendamento.repository;

import br.com.xieba.agendamento.entity.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity,Long> {

    @Query("select c from ContatoEntity c where c.idade > 25")
    List<ContatoEntity> buscarContatoIdadeMaior25();

    @Query("select c from ContatoEntity c where c.idade > :idade")
    List<ContatoEntity> buscarContatoIdadeMaior(Integer idade);

    List<ContatoEntity> findByNome(String nome);

    @Query("select c from ContatoEntity c where c.nome like concat( '%', :nome, '%')")
    List<ContatoEntity> buscarNomeLike(String nome);

    
}
