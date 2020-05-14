package com.buonotec.unitunes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buonotec.unitunes.entities.Universidade;

@Repository
public interface UniversidadeRepository extends JpaRepository<Universidade, Integer>{

}
