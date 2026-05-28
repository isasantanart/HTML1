package com.petz.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petz.petshop.entities.Pedido;

public interface PedidoRepository
        extends JpaRepository<Pedido, Long> {
}