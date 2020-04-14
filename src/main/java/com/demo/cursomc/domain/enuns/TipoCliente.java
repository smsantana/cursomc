package com.demo.cursomc.domain.enuns;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Fisica"),
	PESSOAJURIDICA(2, "Pessoa Juridica");

	private int cod;
	private String descricao;

	/**
	 * @param cod
	 * @param descicao
	 */
	private TipoCliente(int cod, String descicao) {
		this.cod=cod;
		this.descricao=descicao;
	}

	public int getCod() {
		return cod;
	}



	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id invalido:"+cod);
		
	}


	
	

}
