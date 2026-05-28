package com.petz.petshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petz.petshop.entities.Usuario;
import com.petz.petshop.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> listarTodos(){
		return repository.findAll();
	}
	
	public Usuario cadastrar(Usuario usuario) {
		return repository.save(usuario);
	}

	public boolean deletar(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Usuario atualizar(Long id, Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}
	public Usuario buscarPorEmail(String email) {
	    return repository.findByEmail(email);
	}
	public Usuario salvar(Usuario usuario) {
        // Certifique-se de que está chamando o repository.save
        return repository.save(usuario);
    }

}