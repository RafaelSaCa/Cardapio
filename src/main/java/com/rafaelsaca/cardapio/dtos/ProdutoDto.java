package com.rafaelsaca.cardapio.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class ProdutoDto {

    private Long id;
    @NotBlank(message = "O nome é obrigatório!")
    private String nome;
    @NotBlank(message = "A descrição é obrigatória!")
    private String descricao;
    @PositiveOrZero(message = "O valor não pode ser negativo!")
    private Double valor;
    @PositiveOrZero(message = "A quantidade não pode ser negativa!")
    private Integer quantidade;
    @NotBlank(message="O tipo é obrigatório!")
    private String tipo;
    @NotBlank(message="A imagem é obrigatória!")
    private String imgUrl;

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
