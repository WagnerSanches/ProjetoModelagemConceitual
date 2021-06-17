package com.sanches.repositories;

import org.springframework.stereotype.Repository;

import com.sanches.domain.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	
	
}
