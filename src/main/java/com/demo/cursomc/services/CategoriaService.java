package com.demo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.demo.cursomc.domain.Categoria;
import com.demo.cursomc.repositories.CategoriaRepository;
import com.demo.cursomc.services.exceptions.*;

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

	public void delete(Integer id) {
		find(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityExcpetion("Nao e possivel excluir uma categoria que possui produtos!");
		}
	}

}
