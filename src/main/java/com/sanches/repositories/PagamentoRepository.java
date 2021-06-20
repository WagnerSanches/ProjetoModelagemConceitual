package com.sanches.repositories;

import org.springframework.stereotype.Repository;

import com.sanches.domain.Pagamento;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
	
}
