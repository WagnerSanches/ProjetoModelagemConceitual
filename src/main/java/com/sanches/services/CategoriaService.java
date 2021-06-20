package com.sanches.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanches.domain.Categoria;
import com.sanches.repositories.CategoriaRepository;
import com.sanches.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repositoryCategoria;

	public Categoria find(Integer id) {
		Optional<Categoria> cat = repositoryCategoria.findById(id);
		return cat.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encotnrado: [" + id + "], do tipo " + Categoria.class.getSimpleName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repositoryCategoria.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repositoryCategoria.save(obj);
	}

}
