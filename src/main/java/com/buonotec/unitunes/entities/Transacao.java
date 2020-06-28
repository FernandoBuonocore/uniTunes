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

import com.buonotec.unitunes.enumerations.TransacaoTipo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	private Integer transacaoTipo;
	
	//nao vou colocar relacionamento para a Midia, porque ela pode ser apagada, dai teria que fazer muito tratamento
	//por isso somente a descrição
	private String descricaoTransacao;

	@JsonManagedReference
	@ManyToMany
	@JoinTable(name="TRANSACAO_MIDIA", 
		joinColumns = @JoinColumn(name="transacao_id")
			, inverseJoinColumns = @JoinColumn(name="midia_id"))
	private List<Midia> midiasDownload = new ArrayList<Midia>();;
	
	public Transacao() {
	}
	
	public Transacao(Integer id, Usuario usuarioTransacao, Date dataTransacao,
			TransacaoTipo transacaoTipo, String descricaoTransacao) {
		super();
		this.id = id;
		this.usuarioTransacao = usuarioTransacao;
		this.dataTransacao = dataTransacao;
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
		double valor = 0;
		
		for(Midia mid : midiasDownload) {
			valor = valor + mid.getPreco();
		}
		return valor;
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

	public List<Midia> getMidiasDownload() {
		return midiasDownload;
	}

	public void setMidiasDownload(List<Midia> midiasDownload) {
		this.midiasDownload = midiasDownload;
	}
	
}
