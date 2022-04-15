package br.com.xieba.agendamento.repository;

import br.com.xieba.agendamento.entity.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity,Long> {

}
