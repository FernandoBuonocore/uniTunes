package com.buonotec.unitunes.dto;

import java.io.Serializable;

import com.buonotec.unitunes.entities.Universidade;

public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nome;
	private String senha;
	private double saldo;
	private String email;
	private Integer usuarioTipo;
	private Universidade universidade;
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Integer getUsuarioTipo() {
		return usuarioTipo;
	}
	
	public void setUsuarioTipo(Integer usuarioTipo) {
		this.usuarioTipo = usuarioTipo;
	}
	
	public Universidade getUniversidade() {
		return universidade;
	}
	
	public void setUniversidade(Universidade universidade) {
		this.universidade = universidade;
	}
	
}
