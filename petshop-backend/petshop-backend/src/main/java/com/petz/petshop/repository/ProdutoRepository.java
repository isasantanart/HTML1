package com.petz.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petz.petshop.entities.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByCategoriaIdCategoria(Long idCategoria);
}