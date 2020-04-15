package com.demo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cursomc.domain.Cliente;
import com.demo.cursomc.exceptions.CustomObjectNotFoundException;
import com.demo.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente buscar(Integer id) {

		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElseThrow(() -> new CustomObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));

	}

}
