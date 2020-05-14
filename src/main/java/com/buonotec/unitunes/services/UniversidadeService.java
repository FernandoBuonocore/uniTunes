package com.buonotec.unitunes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buonotec.unitunes.entities.Universidade;
import com.buonotec.unitunes.repositories.UniversidadeRepository;
import com.buonotec.unitunes.services.exceptions.ObjectNotFoundException;

@Service
public class UniversidadeService {

	@Autowired
	private UniversidadeRepository universidadeDao;
	
	public Universidade buscarUniversidades(Integer id) {
		Optional<Universidade> opt = universidadeDao.findById(id);
			return opt.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado!"));
	}
	
}
