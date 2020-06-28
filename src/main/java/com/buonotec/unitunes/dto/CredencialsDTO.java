package com.buonotec.unitunes.dto;

import java.io.Serializable;

public class CredencialsDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String email;
	private String senha;
	
	public CredencialsDTO() {
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
