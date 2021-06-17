package com.sanches.repositories;

import org.springframework.stereotype.Repository;

import com.sanches.domain.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	
	
}
