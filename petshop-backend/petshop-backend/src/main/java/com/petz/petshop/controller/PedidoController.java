package com.petz.petshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.petz.petshop.dto.PedidoDTO;
import com.petz.petshop.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
@CrossOrigin("*")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@PostMapping
	public ResponseEntity<?> criarPedido(@RequestBody PedidoDTO dto) {

		return ResponseEntity.ok(pedidoService.salvar(dto));
	}
}