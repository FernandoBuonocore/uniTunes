package com.buonotec.unitunes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.buonotec.unitunes.entities.Universidade;
import com.buonotec.unitunes.entities.Usuario;
import com.buonotec.unitunes.enumerations.UsuarioTipo;
import com.buonotec.unitunes.repositories.UniversidadeRepository;
import com.buonotec.unitunes.repositories.UsuarioRepository;

@SpringBootApplication
public class UniTunesApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(UniTunesApplication.class, args);
	}

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UniversidadeRepository universidadeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Universidade uni1 = new Universidade(null, "Unisinos", 5000);
		
		Usuario user1 = new Usuario(null, "Buonocore", "123", 1000.00, "buonocore@buonotec.com", UsuarioTipo.ADMINISTRADOR, uni1);
		uni1.getUsuarios().add(user1);
		
		universidadeRepository.save(uni1);
		usuarioRepository.save(user1);
		
	}

}
