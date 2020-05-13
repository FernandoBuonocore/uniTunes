package com.buonotec.unitunes.entities;

import java.io.Serializable;
import java.util.Date;

import com.buonotec.unitunes.enumerations.MidiaTipo;

public class Midia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String descricao;
	private byte imagem;
	private double preco;
	private boolean livre;
	private byte conteudo;
	private Date data;
	
	private MidiaTipo tipo;
	private Usuario usuarioCriador;
	
}
