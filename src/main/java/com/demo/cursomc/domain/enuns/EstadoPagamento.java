package com.demo.cursomc.domain.enuns;

public enum EstadoPagamento {
	
	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	CANCELADO(3, "Cancelado");
	

	private int id;
	private String descricao;

	EstadoPagamento(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public int getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer id) {
		
		if(id == null) {
			return null;
		}
		
		for(EstadoPagamento it : EstadoPagamento.values()) {
			if(id.equals(it.getId())) {
				return it;
			}
		}
		
		return null;
	}

}
