package com.buonotec.unitunes.enumerations;

public enum TransacaoTipo {

	CREDITO (1, "Credito"),
	TRANSFERENCIA(2, "Transferencia"),
	BOLETO(3, "Boleto");

	private int id;
	private String descricao;
	
	private TransacaoTipo(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static TransacaoTipo toEnum(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		
		for(TransacaoTipo tipo : TransacaoTipo.values()) {
			if(codigo.equals(tipo.getId())) {
				return tipo;
			}
		}
		return null;
	}
	
}
