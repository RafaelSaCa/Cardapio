package com.rafaelsaca.cardapio.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rafaelsaca.cardapio.dtos.ProdutoDto;
import com.rafaelsaca.cardapio.exceptions.RecursoNotFoundException;
import com.rafaelsaca.cardapio.mappers.ProdutoMapper;
import com.rafaelsaca.cardapio.models.Produto;
import com.rafaelsaca.cardapio.repositories.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;

    public ProdutoService(ProdutoRepository repository, ProdutoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public ProdutoDto cadastraProduto (ProdutoDto produtoDto){
        Produto produto = mapper.toEntity(produtoDto);
        Produto produtoSalvo = repository.save(produto);

        return mapper.toDto(produtoSalvo);
    }


    public List<ProdutoDto> listaProdutos (){
        List<Produto> produtos = repository.findAll();
        return mapper.toListDto(produtos);
    }


    public ProdutoDto buscaProduto (Long id){
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RecursoNotFoundException("Produto não encontrado!"));

        return mapper.toDto(produto);
    }

    @Transactional
    public ProdutoDto atualizarProduto (Long id, ProdutoDto produtoDto){
        Produto produtoExistente = repository.findById(id)
                .orElseThrow(() -> new RecursoNotFoundException("Produto não encontrado!"));

        produtoExistente.setNome(produtoDto.getNome());
        produtoExistente.setDescricao(produtoDto.getDescricao());
        produtoExistente.setValor(produtoDto.getValor());
        produtoExistente.setQuantidade(produtoDto.getQuantidade());
        produtoExistente.setTipo(produtoDto.getTipo());
        produtoExistente.setImgUrl(produtoDto.getImgUrl());

        Produto produtoSalvo = repository.save(produtoExistente);
        return mapper.toDto(produtoSalvo);
    }

    @Transactional
    public void removeProduto (Long id){
        if(!repository.existsById(id)){
            throw new RecursoNotFoundException("Produto não encontrado!");
        }
        repository.deleteById(id);
    }
  
}
