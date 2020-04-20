package com.demo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cursomc.domain.Categoria;
import com.demo.cursomc.domain.Pedido;
import com.demo.cursomc.repositories.PedidoRepository;
import com.demo.cursomc.services.exceptions.CustomObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	public Pedido find(Integer id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		return pedido.orElseThrow(() -> new CustomObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
