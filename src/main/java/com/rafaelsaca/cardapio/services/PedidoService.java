package com.rafaelsaca.cardapio.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rafaelsaca.cardapio.dtos.ItemPedidoDto;
import com.rafaelsaca.cardapio.dtos.PedidoDto;
import com.rafaelsaca.cardapio.dtos.response.ProdutoResponse;
import com.rafaelsaca.cardapio.exceptions.RecursoNotFoundException;
import com.rafaelsaca.cardapio.mappers.PedidoMapper;
import com.rafaelsaca.cardapio.mappers.ProdutoMapper;
import com.rafaelsaca.cardapio.models.Pedido;
import com.rafaelsaca.cardapio.models.Pedido.StatusPedido;
import com.rafaelsaca.cardapio.models.Produto;
import com.rafaelsaca.cardapio.models.User;
import com.rafaelsaca.cardapio.repositories.PedidoRepository;
import com.rafaelsaca.cardapio.repositories.ProdutoRepository;
import com.rafaelsaca.cardapio.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {

    private final PedidoRepository repository;
    private final ProdutoRepository produtoRepository;
    private final UserRepository usuarioRepository;
    private final ProdutoMapper produtoMapper;
    private final PedidoMapper pedidoMapper;

    public PedidoService(PedidoRepository repository, ProdutoRepository produtoRepository,
    UserRepository usuarioRepository, ProdutoMapper produtoMapper, PedidoMapper pedidoMapper) {
        this.repository = repository;
        this.produtoRepository = produtoRepository;
        this.usuarioRepository = usuarioRepository;
        this.produtoMapper = produtoMapper;
        this.pedidoMapper = pedidoMapper;
    }

    @Transactional
    public PedidoDto geraPedido(Long usuarioId, List<ItemPedidoDto> itens) {
        User usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RecursoNotFoundException("Usuário não encontrado!"));

        PedidoDto pedidoDto = new PedidoDto();
        pedidoDto.setUsuario(usuario);
        pedidoDto.setDataPedido(LocalDateTime.now());
        pedidoDto.setStatus(StatusPedido.PREPARANDO);

        for (ItemPedidoDto item : itens) {
            Produto produto = produtoRepository.findById(item.getProduto().getId())
                    .orElseThrow(() -> new RecursoNotFoundException("Produto não encontrado!"));

            ProdutoResponse produtoResponse = produtoMapper.toResponse(produto);
            item.setProduto(produtoResponse);
            item.setValor(produtoResponse.getValor());
            item.setPedido(pedidoDto);
        }

        pedidoDto.setItens(itens);
        pedidoDto.calculaValorTotal();

        Pedido pedido = pedidoMapper.toEntity(pedidoDto);
        Pedido pedidoSalvo = repository.save(pedido);

        return pedidoMapper.toDto(pedidoSalvo);
    }

    public List<Pedido> listaPedidos() {
        return repository.findAll();
    }

    public PedidoDto buscaPedido(Long pedidoId) {
        Pedido pedido = repository.findById(pedidoId)
                .orElseThrow(() -> new RecursoNotFoundException("Pedido não encontrado!"));
        return pedidoMapper.toDto(pedido);
    }

    @Transactional
    public PedidoDto atualizarPedido(Long pedidoId, List<ItemPedidoDto> novosItens) {
        Pedido pedidoExistente = repository.findById(pedidoId)
                .orElseThrow(() -> new RecursoNotFoundException("Pedido não encontrado!"));

        pedidoExistente.getItens().clear();
        PedidoDto pedidoDto = pedidoMapper.toDto(pedidoExistente);

        for (ItemPedidoDto item : novosItens) {
            Produto produto = produtoRepository.findById(item.getProduto().getId())
                    .orElseThrow(() -> new RecursoNotFoundException("Produto não encontrado!"));

            ProdutoResponse produtoResponse = produtoMapper.toResponse(produto);
            item.setProduto(produtoResponse);
            item.setValor(produtoResponse.getValor());
            item.setPedido(pedidoDto);
        }
        pedidoDto.setItens(novosItens);
        pedidoDto.calculaValorTotal();
        pedidoDto.setDataPedido(LocalDateTime.now());
     

        Pedido pedido = pedidoMapper.toEntity(pedidoDto);
        Pedido pedidoAtualizado = repository.save(pedido);

        return pedidoMapper.toDto(pedidoAtualizado);
    }

}
