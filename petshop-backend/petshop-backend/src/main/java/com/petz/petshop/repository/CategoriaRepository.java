package com.petz.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petz.petshop.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}