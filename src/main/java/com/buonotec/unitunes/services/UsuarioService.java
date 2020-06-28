package com.buonotec.unitunes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.buonotec.unitunes.entities.Usuario;
import com.buonotec.unitunes.repositories.UsuarioRepository;
import com.buonotec.unitunes.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder bt;
	
	public Usuario buscarUsuarios(Integer id) {
		Optional<Usuario> opt = repo.findById(id);
			return opt.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado!"));
	}
	
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj.setSenha(bt.encode(obj.getSenha()));
		obj = repo.save(obj);
		return obj;
	}
	
}
