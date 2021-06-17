package com.sanches.repositories;

import org.springframework.stereotype.Repository;

import com.sanches.domain.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
	
}
