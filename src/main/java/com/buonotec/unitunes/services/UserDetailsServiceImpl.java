package com.buonotec.unitunes.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.buonotec.unitunes.entities.Usuario;
import com.buonotec.unitunes.enumerations.UsuarioTipo;
import com.buonotec.unitunes.repositories.UsuarioRepository;
import com.buonotec.unitunes.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario user = repo.findByEmail(email);
		
		if(user == null) {
			throw new UsernameNotFoundException(email);
		}
		
		Set<UsuarioTipo> tipo = new HashSet<>();
		tipo.add(user.getUsuarioTipo());
		return new UserSS(user.getId(), user.getEmail(), user.getSenha(), tipo);
	}

}
