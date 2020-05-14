package com.buonotec.unitunes;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.buonotec.unitunes.entities.Transacao;
import com.buonotec.unitunes.entities.Universidade;
import com.buonotec.unitunes.entities.Usuario;
import com.buonotec.unitunes.enumerations.TransacaoTipo;
import com.buonotec.unitunes.enumerations.UsuarioTipo;
import com.buonotec.unitunes.repositories.TransacaoRepository;
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
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Universidade uni1 = new Universidade(null, "Unisinos", 5000);
		
		Usuario user1 = new Usuario(null, "Buonocore", "123", 1000.00, "buonocore@buonotec.com", UsuarioTipo.ADMINISTRADOR, uni1);
		uni1.getUsuarios().add(user1);
		
		Transacao tran1 = new Transacao(null, user1, new Date(), 10.00, TransacaoTipo.BOLETO, "Compra produto Livro");
		Transacao tran2 = new Transacao(null, user1, new Date(), 1.00, TransacaoTipo.TRANSFERENCIA, "Compra produto Musica");
		
		user1.getTransacoes().addAll(Arrays.asList(tran1, tran2));
		
		universidadeRepository.save(uni1);
		
		
		usuarioRepository.save(user1);
		transacaoRepository.saveAll(Arrays.asList(tran1, tran2));
	}

}
