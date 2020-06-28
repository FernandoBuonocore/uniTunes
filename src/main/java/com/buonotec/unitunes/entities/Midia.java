package com.buonotec.unitunes.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.buonotec.unitunes.enumerations.MidiaTipo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Midia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private Byte imagem;
	private double preco;
	private boolean livre;
	private Byte conteudo;
	private Date data;
	
	private Integer tipo;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuarioCriador;
	
	
	@JsonBackReference
	@ManyToMany(mappedBy = "midiasDownload")
	private List<Transacao> midiasDown = new ArrayList<Transacao>();
	
	public Midia() {
	}
	public Midia(Integer id, String nome, String descricao, Byte imagem, double preco, boolean livre, Byte conteudo,
			Date data, MidiaTipo tipo, Usuario usuarioCriador) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.imagem = imagem;
		this.preco = preco;
		this.livre = livre;
		this.conteudo = conteudo;
		this.data = data;
		this.tipo = tipo.getId();
		this.usuarioCriador = usuarioCriador;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Byte getImagem() {
		return imagem;
	}
	public void setImagem(Byte imagem) {
		this.imagem = imagem;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public boolean isLivre() {
		return livre;
	}
	public void setLivre(boolean livre) {
		this.livre = livre;
	}
	public Byte getConteudo() {
		return conteudo;
	}
	public void setConteudo(Byte conteudo) {
		this.conteudo = conteudo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public MidiaTipo getTipo() {
		return MidiaTipo.toEnum(tipo);
	}
	public void setTipo(MidiaTipo tipo) {
		this.tipo = tipo.getId();
	}
	public Usuario getUsuarioCriador() {
		return usuarioCriador;
	}
	public void setUsuarioCriador(Usuario usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}
	
	
}
