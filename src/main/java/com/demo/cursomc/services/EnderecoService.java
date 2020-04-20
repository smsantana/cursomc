package com.demo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cursomc.domain.Endereco;
import com.demo.cursomc.repositories.EnderecoRepository;
import com.demo.cursomc.services.exceptions.CustomObjectNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Endereco find(Integer id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		return endereco.orElseThrow(() -> new CustomObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));

	}
}
