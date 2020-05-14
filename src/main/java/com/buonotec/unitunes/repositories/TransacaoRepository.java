package com.buonotec.unitunes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buonotec.unitunes.entities.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{

}
