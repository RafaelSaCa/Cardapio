package com.rafaelsaca.cardapio.mappers;

import com.rafaelsaca.cardapio.dtos.ItemPedidoDto;
import com.rafaelsaca.cardapio.models.ItemPedido;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemPedidoMapper {
    private final ModelMapper mapper;

    public ItemPedidoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public ItemPedidoDto toDto (ItemPedido itemPedido){
        return mapper.map(itemPedido,ItemPedidoDto.class);
    }

    public ItemPedido toEntity (ItemPedidoDto itemPedidoDto){
        return mapper.map(itemPedidoDto,ItemPedido.class);
    }

    public List<ItemPedidoDto> toListDto (List<ItemPedido> itens){
        return itens.stream().map(itemPedido -> mapper.map(itemPedido,ItemPedidoDto.class))
                .collect(Collectors.toList());
    }
}
