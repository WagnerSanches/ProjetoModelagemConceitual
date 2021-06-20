package com.sanches.repositories;

import org.springframework.stereotype.Repository;

import com.sanches.domain.ItemPedido;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
	
	
}
