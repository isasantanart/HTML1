package com.petz.petshop.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petz.petshop.dto.PedidoDTO;
import com.petz.petshop.dto.PedidoItemDTO;
import com.petz.petshop.entities.Pedido;
import com.petz.petshop.entities.PedidoItem;
import com.petz.petshop.repository.PedidoItemRepository;
import com.petz.petshop.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoItemRepository itemRepository;

    public Pedido salvar(PedidoDTO dto) {

        Pedido pedido = new Pedido();

        pedido.setTotal(dto.getTotal());

        pedido.setDataPedido(LocalDateTime.now());

        Pedido pedidoSalvo =
                pedidoRepository.save(pedido);

        for (PedidoItemDTO itemDTO : dto.getItens()) {

            PedidoItem item = new PedidoItem();

            item.setProdutoId(itemDTO.getProdutoId());

            item.setQuantidade(itemDTO.getQuantidade());

            item.setSubtotal(itemDTO.getSubtotal());

            item.setPedido(pedidoSalvo);

            itemRepository.save(item);
        }

        return pedidoSalvo;
    }
}