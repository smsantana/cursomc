package com.demo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.cursomc.domain.Categoria;
import com.demo.cursomc.repositories.CategoriaRepository;
import com.demo.cursomc.exceptions.*;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository repository;
	
	public Categoria find(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new CustomObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	
	
	public void insert(Categoria obj) {
		obj.setId(null);
		obj = repository.save(obj);
	}



	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repository.save(obj);
	}

}
