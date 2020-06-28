package com.buonotec.unitunes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.buonotec.unitunes.entities.Midia;

@Repository
public interface MidiaRepository extends JpaRepository<Midia, Integer>{

}
