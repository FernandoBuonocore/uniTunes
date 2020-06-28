package com.buonotec.unitunes;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.buonotec.unitunes.entities.Midia;
import com.buonotec.unitunes.entities.Transacao;
import com.buonotec.unitunes.entities.Universidade;
import com.buonotec.unitunes.entities.Usuario;
import com.buonotec.unitunes.enumerations.MidiaTipo;
import com.buonotec.unitunes.enumerations.TransacaoTipo;
import com.buonotec.unitunes.enumerations.UsuarioTipo;
import com.buonotec.unitunes.repositories.MidiaRepository;
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
	
	@Autowired
	private MidiaRepository midiaRepository;
	
	@Autowired
	private BCryptPasswordEncoder bt;
	
	@Override
	public void run(String... args) throws Exception {
		Universidade uni1 = new Universidade(null, "Unisinos", 5000);
		
		Usuario user1 = new Usuario(null, "Buonocore", bt.encode("123"), 1000.00, "buonocore@buonotec.com", UsuarioTipo.ADMINISTRADOR, uni1);
		uni1.getUsuarios().add(user1);
		
		Transacao tran1 = new Transacao(null, user1, new Date(), TransacaoTipo.BOLETO, "Compra produto Livro");
		Transacao tran2 = new Transacao(null, user1, new Date(), TransacaoTipo.TRANSFERENCIA, "Compra produto Musica");
		
		
		universidadeRepository.save(uni1);
		
		Midia m1 = new Midia(null, "O caldeirão Azul", "Livro sobre o planeta Terra", null, 39.90, false, 
				null, new Date(), MidiaTipo.LIVRO, user1);
		
		Midia m2 = new Midia(null, "A dança do universo", "Livro sobre origem do universo", null, 29.90, false, 
				null, new Date(), MidiaTipo.LIVRO, user1);

		
		tran1.getMidiasDownload().addAll(Arrays.asList(m1,m2));
		
		user1.getTransacoes().addAll(Arrays.asList(tran1, tran2));
		usuarioRepository.save(user1);
		midiaRepository.save(m1);
		midiaRepository.save(m2);
		transacaoRepository.saveAll(Arrays.asList(tran1, tran2));
	}

}
