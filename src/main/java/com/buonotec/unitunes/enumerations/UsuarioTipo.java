package com.buonotec.unitunes.enumerations;

public enum UsuarioTipo {

	ACADEMICO (1, "Academico"),
	ADMINISTRADOR(2, "Admin");

	private int id;
	private String descricao;
	
	private UsuarioTipo(int id, String descricao) {
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

	public static UsuarioTipo toEnum(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		
		for(UsuarioTipo tipo : UsuarioTipo.values()) {
			if(codigo.equals(tipo.getId())) {
				return tipo;
			}
		}
		return null;
	}
	
}
