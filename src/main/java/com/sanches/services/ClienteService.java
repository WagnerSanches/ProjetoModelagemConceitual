package com.sanches.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanches.domain.Cliente;
import com.sanches.repositories.ClienteRepository;
import com.sanches.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repositoryCliente;

	public Cliente buscar(Integer id) {
		Optional<Cliente> cat = repositoryCliente.findById(id);
		return cat.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encotnrado: [" + id + "], do tipo " + Cliente.class.getSimpleName()));
	}

}
