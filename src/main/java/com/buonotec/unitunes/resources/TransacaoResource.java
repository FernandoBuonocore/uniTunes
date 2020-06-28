package com.buonotec.unitunes.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.buonotec.unitunes.entities.Transacao;
import com.buonotec.unitunes.services.TransacaoService;

@RestController
@RequestMapping(value="/transacoes")
public class TransacaoResource {

	@Autowired
	private TransacaoService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Transacao obj = service.buscarTransacao(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		
		List<Transacao> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	
}
