package com.petz.petshop.service;

import com.petz.petshop.entities.Categoria;
import com.petz.petshop.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> listarTodos() {
        return repository.findAll();
    }

    public Categoria criar(Categoria categoria) {
        categoria.setIdCategoria(null);
        return repository.save(categoria);
    }

    public Categoria atualizar(Long id, Categoria categoria) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada");
        }
        categoria.setIdCategoria(id);
        return repository.save(categoria);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada");
        }
        repository.deleteById(id);
    }
}