package com.rafaelsaca.cardapio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome é obrigatório!")
    private String nome;
    @NotBlank(message = "A descrição é obrigatória!")
    private String descricao;
    @PositiveOrZero(message = "O valor não pode ser negativo!")
    private Double valor;
    @PositiveOrZero(message = "A quantidade não pode ser negativa!")
    private Integer quantidade;
    @NotBlank(message="O tipo é obrigatório")
    private String tipo;
    @NotBlank(message="A imagem é obrigatória!")
    private String imgUrl;

    public Produto() {
    }

    public Produto(String descricao, Long id, String imgUrl, String nome, Integer quantidade, String tipo, Double valor) {
        this.descricao = descricao;
        this.id = id;
        this.imgUrl = imgUrl;
        this.nome = nome;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    
}
