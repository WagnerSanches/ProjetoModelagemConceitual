package com.sanches.repositories;

import org.springframework.stereotype.Repository;

import com.sanches.domain.Estado;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	
	
}
