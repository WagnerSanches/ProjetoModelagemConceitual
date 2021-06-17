package com.sanches.repositories;

import org.springframework.stereotype.Repository;

import com.sanches.domain.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	
}
