package com.petz.petshop.entities; // ou entities, ajuste conforme seu projeto

import jakarta.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 255)
    private String descricao;

    @Column(length = 50)
    private String icone;

    private Boolean ativo = true;

    // Construtores
    public Categoria() {}

    public Categoria(Long idCategoria, String nome, String descricao, String icone, Boolean ativo) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.descricao = descricao;
        this.icone = icone;
        this.ativo = ativo;
    }

    // Getters e Setters
    public Long getIdCategoria() { return idCategoria; }
    public void setIdCategoria(Long idCategoria) { this.idCategoria = idCategoria; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getIcone() { return icone; }
    public void setIcone(String icone) { this.icone = icone; }

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}