package com.buonotec.unitunes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buonotec.unitunes.entities.Usuario;
import com.buonotec.unitunes.repositories.UsuarioRepository;
import com.buonotec.unitunes.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioDao;
	
	public Usuario buscarUsuarios(Integer id) {
		Optional<Usuario> opt = usuarioDao.findById(id);
			return opt.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado!"));
	}
	
}
