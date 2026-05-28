package com.petz.petshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;

    @Column(nullable = false, length = 150)
    private String nome;

    private Double preco;
    private Double precoDesconto;
    private Integer qtdEstoque;

    @Column(length = 500)
    private String imagem;

    private Boolean ativo = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties("produtos")
    private Categoria categoria;

    // Construtores
    public Produto() {}

    public Produto(Long idProduto, String nome, Double preco, Double precoDesconto, Integer qtdEstoque, String imagem, Boolean ativo, Categoria categoria) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.precoDesconto = precoDesconto;
        this.qtdEstoque = qtdEstoque;
        this.imagem = imagem;
        this.ativo = ativo;
        this.categoria = categoria;
    }

    // Getters e Setters (apenas os essenciais mostrados, complete todos)
    public Long getIdProduto() { return idProduto; }
    public void setIdProduto(Long idProduto) { this.idProduto = idProduto; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public Double getPrecoDesconto() { return precoDesconto; }
    public void setPrecoDesconto(Double precoDesconto) { this.precoDesconto = precoDesconto; }

    public Integer getQtdEstoque() { return qtdEstoque; }
    public void setQtdEstoque(Integer qtdEstoque) { this.qtdEstoque = qtdEstoque; }

    public String getImagem() { return imagem; }
    public void setImagem(String imagem) { this.imagem = imagem; }

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}