package com.rafaelsaca.cardapio.models;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private BigDecimal valor;
    @PositiveOrZero(message = "A quantidade não pode ser negativa!")
    private Integer quantidade;

    public Produto() {
    }

    public Produto(Integer quantidade, BigDecimal valor, String descricao, String nome, Long id) {
        this.quantidade = quantidade;
        this.valor = valor;
        this.descricao = descricao;
        this.nome = nome;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "O nome é obrigatório!") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório!") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "A descrição é obrigatória!") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotBlank(message = "A descrição é obrigatória!") String descricao) {
        this.descricao = descricao;
    }

    public @PositiveOrZero(message = "O valor não pode ser negativo!") BigDecimal getValor() {
        return valor;
    }

    public void setValor(@PositiveOrZero(message = "O valor não pode ser negativo!") BigDecimal valor) {
        this.valor = valor;
    }

    public @PositiveOrZero(message = "A quantidade não pode ser negativa!") Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@PositiveOrZero(message = "A quantidade não pode ser negativa!") Integer quantidade) {
        this.quantidade = quantidade;
    }
}
