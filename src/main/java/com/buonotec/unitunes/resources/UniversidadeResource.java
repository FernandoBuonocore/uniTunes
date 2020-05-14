package com.buonotec.unitunes.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.buonotec.unitunes.entities.Universidade;
import com.buonotec.unitunes.services.UniversidadeService;

@RestController
@RequestMapping(value="/universidades")
public class UniversidadeResource {

	@Autowired
	private UniversidadeService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Universidade obj = service.buscarUniversidades(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
