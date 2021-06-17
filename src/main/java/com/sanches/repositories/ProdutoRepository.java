package com.sanches.repositories;

import org.springframework.stereotype.Repository;

import com.sanches.domain.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
}
