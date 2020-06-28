package com.buonotec.unitunes.dto;

import java.io.Serializable;
import java.util.Date;

public class RelatorioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nomeUsuario;
	
	private Date dataTransacao;
	
	private double valor;
	
	private Integer transacaoTipo;
	
	private String descricaoTransacao;

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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

	public Integer getTransacaoTipo() {
		return transacaoTipo;
	}

	public void setTransacaoTipo(Integer transacaoTipo) {
		this.transacaoTipo = transacaoTipo;
	}

	public String getDescricaoTransacao() {
		return descricaoTransacao;
	}

	public void setDescricaoTransacao(String descricaoTransacao) {
		this.descricaoTransacao = descricaoTransacao;
	}

}
