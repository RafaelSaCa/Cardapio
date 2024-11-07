package com.rafaelsaca.cardapio.dtos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.rafaelsaca.cardapio.models.Pedido;
import com.rafaelsaca.cardapio.models.Usuario;

public class PedidoDto {

    private Long id;

    private Usuario usuario;

    private List<ItemPedidoDto> itens = new ArrayList<>();
 
    private LocalDateTime dataPedido;

    private Pedido.StatusPedido status;

    private Double valorTotal;

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemPedidoDto> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoDto> itens) {
        this.itens = itens;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Pedido.StatusPedido getStatus() {
        return status;
    }

    public void setStatus(Pedido.StatusPedido status) {
        this.status = status;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void calculaValorTotal(){
        valorTotal = itens.stream()
                    .mapToDouble(item -> item.getValor() * item.getQuantidade()).sum();
    }

}
