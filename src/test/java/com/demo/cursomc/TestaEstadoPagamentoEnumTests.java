package com.demo.cursomc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.demo.cursomc.domain.enuns.EstadoPagamento;


public class TestaEstadoPagamentoEnumTests {
	
	@Test
	public void verifyValuesEnum() {
		assertEquals(EstadoPagamento.PENDENTE, EstadoPagamento.toEnum(1));
	}

}
