package com.rafaelsaca.cardapio.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelsaca.cardapio.dtos.ItemPedidoDto;
import com.rafaelsaca.cardapio.dtos.PedidoDto;
import com.rafaelsaca.cardapio.dtos.request.PedidoResquest;
import com.rafaelsaca.cardapio.models.Pedido;
import com.rafaelsaca.cardapio.services.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PedidoDto> criaPedido(@RequestBody PedidoResquest request) {
        PedidoDto pedidoDto = service.geraPedido(request.getUsuarioId(), request.getItens());
        return ResponseEntity.ok(pedidoDto);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listaPedidos() {
        List<Pedido> pedidos = service.listaPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> busca(@PathVariable Long id) {
        PedidoDto pedidoDto = service.buscaPedido(id);
        return ResponseEntity.ok(pedidoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDto> atualizaPedido(@PathVariable Long id, @RequestBody List<ItemPedidoDto> novosItens){
        PedidoDto pedidoAtualizado = service.atualizarPedido(id, novosItens);
        return ResponseEntity.ok(pedidoAtualizado);
    }

 
}
