package com.petz.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petz.petshop.entities.Usuario;
import com.petz.petshop.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired 
	private UsuarioService service;
	
	@GetMapping
	public List<Usuario> listarUsuarios(){
		return service.listarTodos();
	}
	@PostMapping
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
	    Usuario novoUsuario = service.salvar(usuario); 
	    if (novoUsuario == null) {
	        return ResponseEntity.badRequest().build();
	    }
	    return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
	}
    
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Usuario loginData) {
	    Usuario usuario = service.buscarPorEmail(loginData.getEmail());

	    if (usuario != null && usuario.getSenha().equals(loginData.getSenha())) {
	        return ResponseEntity.ok(usuario);
	    }

	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("E-mail ou senha inválidos");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {

	boolean removido = service.deletar(id);

	if (!removido) {
	return ResponseEntity.notFound().build();
	}

	return ResponseEntity.noContent().build(); // 204
	//return ResponseEntity.ok(usuarioDeletado);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizarUsuario(
	@PathVariable Long id,
	@RequestBody Usuario usuario) {

	Usuario usuarioAtualizado = service.atualizar(id, usuario);

	if (usuarioAtualizado == null) {
	return ResponseEntity.notFound().build();
	}

	return ResponseEntity.ok(usuarioAtualizado);
	}

}