package com.sanches.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanches.domain.Pedido;
import com.sanches.repositories.PedidoRepository;
import com.sanches.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repositoryPedido;

	public Pedido find(Integer id) {
		Optional<Pedido> cat = repositoryPedido.findById(id);
		return cat.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encotnrado: [" + id + "], do tipo " + Pedido.class.getSimpleName()));
	}

}
