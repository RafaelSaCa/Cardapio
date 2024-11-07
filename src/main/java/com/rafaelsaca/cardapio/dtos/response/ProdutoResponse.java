package com.rafaelsaca.cardapio.dtos.response;

public class ProdutoResponse {

    private Long id;
    private String nome;
    private String descricao;
    private Double valor;
    private Integer quantidade;
    private String tipo;
    private String imgUrl;

    public ProdutoResponse() {
    }

    public ProdutoResponse(String descricao, Long id, String imgUrl, String nome, Integer quantidade, String tipo, Double valor) {
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

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public String getImgUrl() {
        return imgUrl;
    }


}
