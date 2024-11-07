package com.rafaelsaca.cardapio.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rafaelsaca.cardapio.dtos.response.ProdutoResponse;

import jakarta.validation.constraints.NotBlank;

public class ItemPedidoDto {

    private Long id;
    @NotBlank(message = "O produto é obrigatório!")
    private ProdutoResponse produto;
    @NotBlank(message = "A quantidade é obrigatória!")
    private Integer quantidade;
    @NotBlank(message = "O valor é obrigatório!")
    private Double valor;
    @JsonIgnore
    private PedidoDto pedido;

    
    public ItemPedidoDto() {
    }

    public ItemPedidoDto(Long id, PedidoDto pedido, ProdutoResponse produto, Integer quantidade, Double valor) {
        this.id = id;
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProdutoResponse getProduto() {
        return produto;
    }

    public void setProduto(ProdutoResponse produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public PedidoDto getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDto pedido) {
        this.pedido = pedido;
    }




}