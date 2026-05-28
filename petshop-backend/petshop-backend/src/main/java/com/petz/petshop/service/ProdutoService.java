package com.petz.petshop.service;

import com.petz.petshop.entities.Produto;
import com.petz.petshop.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto criar(Produto produto) {
        produto.setIdProduto(null);
        return repository.save(produto);
    }

    public Produto atualizar(Long id, Produto produto) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        produto.setIdProduto(id);
        return repository.save(produto);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado");
        }
        repository.deleteById(id);
    }

    // NOVO MÉTODO: buscar por ID
    public Optional<Produto> buscarPorId(Long id) {
        return repository.findById(id);
    }
}