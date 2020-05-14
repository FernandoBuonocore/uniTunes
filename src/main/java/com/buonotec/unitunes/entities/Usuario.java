package com.buonotec.unitunes.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.buonotec.unitunes.enumerations.UsuarioTipo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String senha;
	private double saldo;
	private String email;
	private Integer usuarioTipo;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="universidade_id")
	private Universidade universidade;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "usuarioCriador")
	private List<Midia> midiasCriadas = new ArrayList<>();

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

	public UsuarioTipo getUsuarioTipo() {
		return UsuarioTipo.toEnum(usuarioTipo);
	}

	public void setUsuarioTipo(UsuarioTipo usuarioTipo) {
		this.usuarioTipo = usuarioTipo.getId();
	}

	public Universidade getUniversidade() {
		return universidade;
	}

	public void setUniversidade(Universidade universidade) {
		this.universidade = universidade;
	}

	public Usuario() {
	}
	public Usuario(Integer id, String nome, String senha, double saldo, String email, UsuarioTipo usuarioTipo,
			Universidade universidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.saldo = saldo;
		this.email = email;
		this.usuarioTipo = usuarioTipo.getId();
		this.universidade = universidade;
	}
	
}
