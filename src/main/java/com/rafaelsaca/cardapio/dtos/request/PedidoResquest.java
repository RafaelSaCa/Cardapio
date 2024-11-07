package com.rafaelsaca.cardapio.dtos.request;

import java.util.List;

import com.rafaelsaca.cardapio.dtos.ItemPedidoDto;

public class PedidoResquest {

    private Long usuarioId;
    private List<ItemPedidoDto> itens;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public List<ItemPedidoDto> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoDto> itens) {
        this.itens = itens;
    }

}
