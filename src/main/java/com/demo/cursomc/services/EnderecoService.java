package com.demo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cursomc.domain.Endereco;
import com.demo.cursomc.exceptions.CustomObjectNotFoundException;
import com.demo.cursomc.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public Endereco buscar(Integer id) {
		Optional<Endereco> endereco = enderecoRepository.findById(id);
		return endereco.orElseThrow(() -> new CustomObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));

	}
}
