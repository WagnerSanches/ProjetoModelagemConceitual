package com.sanches.repositories;

import org.springframework.stereotype.Repository;

import com.sanches.domain.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	
}
