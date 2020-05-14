package com.buonotec.unitunes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buonotec.unitunes.entities.Transacao;
import com.buonotec.unitunes.repositories.TransacaoRepository;
import com.buonotec.unitunes.services.exceptions.ObjectNotFoundException;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository usuarioDao;
	
	public Transacao buscarTransacao(Integer id) {
		Optional<Transacao> opt = usuarioDao.findById(id);
			return opt.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado!"));
	}
	
}
