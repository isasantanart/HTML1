package com.petz.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petz.petshop.entities.PedidoItem;

public interface PedidoItemRepository
        extends JpaRepository<PedidoItem, Long> {
}