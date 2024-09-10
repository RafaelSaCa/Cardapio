package com.rafaelsaca.cardapio.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.rafaelsaca.cardapio.dtos.ProdutoDto;
import com.rafaelsaca.cardapio.models.Produto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoMapper {

    private final ModelMapper mapper;    

    public ProdutoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ProdutoDto toDto (Produto produto){
        return mapper.map(produto, ProdutoDto.class);
    }

    public Produto toEntity (ProdutoDto produtoDto){
        return mapper.map(produtoDto, Produto.class);
    }
    
    public List<ProdutoDto> toListDto (List<Produto> produtos){
        return produtos.stream().map(produto -> mapper.map(produto,ProdutoDto.class))
                .collect(Collectors.toList());
    }


}
