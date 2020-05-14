package com.buonotec.unitunes.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.buonotec.unitunes.enumerations.TransacaoTipo;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Transacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuarioTransacao;
	
	private Date dataTransacao;
	
	private double valor;
	
	private Integer transacaoTipo;
	
	//nao vou colocar relacionamento para a Midia, porque ela pode ser apagada, dai teria que fazer muito tratamento
	//por isso somente a descrição
	private String descricaoTransacao;

	public Transacao() {
	}
	
	public Transacao(Integer id, Usuario usuarioTransacao, Date dataTransacao, double valor,
			TransacaoTipo transacaoTipo, String descricaoTransacao) {
		super();
		this.id = id;
		this.usuarioTransacao = usuarioTransacao;
		this.dataTransacao = dataTransacao;
		this.valor = valor;
		this.transacaoTipo = transacaoTipo.getId();
		this.descricaoTransacao = descricaoTransacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuarioTransacao() {
		return usuarioTransacao;
	}

	public void setUsuarioTransacao(Usuario usuarioTransacao) {
		this.usuarioTransacao = usuarioTransacao;
	}

	public Date getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public TransacaoTipo getTransacaoTipo() {
		return TransacaoTipo.toEnum(transacaoTipo);
	}

	public void setTransacaoTipo(TransacaoTipo transacaoTipo) {
		this.transacaoTipo = transacaoTipo.getId();
	}

	public String getDescricaoTransacao() {
		return descricaoTransacao;
	}

	public void setDescricaoTransacao(String descricaoTransacao) {
		this.descricaoTransacao = descricaoTransacao;
	}
	
}
