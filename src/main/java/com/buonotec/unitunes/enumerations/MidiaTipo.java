package com.buonotec.unitunes.enumerations;

public enum MidiaTipo {

	MUSICA (1, "Musica"),
	LIVRO(2, "Livro"),
	VIDEO(3, "Video"),
	PODCAST(4, "PodCast");

	private int id;
	private String descricao;
	
	private MidiaTipo(int id, String descricao) {
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

	public static MidiaTipo toEnum(Integer codigo) {
		if(codigo == null) {
			return null;
		}
		
		for(MidiaTipo tipo : MidiaTipo.values()) {
			if(codigo.equals(tipo.getId())) {
				return tipo;
			}
		}
		return null;
	}
	
}
