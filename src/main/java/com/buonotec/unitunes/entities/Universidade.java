package com.buonotec.unitunes.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Universidade implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer totalAlunos;
	
	@JsonBackReference
	@OneToMany(mappedBy = "universidade")
	private List<Usuario> usuarios = new ArrayList<>();
	
	public Universidade() {
	}
	
	public Universidade(Integer id, String nome, Integer totalAlunos) {
		super();
		this.id = id;
		this.nome = nome;
		this.totalAlunos = totalAlunos;
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
	public Integer getTotalAlunos() {
		return totalAlunos;
	}
	public void setTotalAlunos(Integer totalAlunos) {
		this.totalAlunos = totalAlunos;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
