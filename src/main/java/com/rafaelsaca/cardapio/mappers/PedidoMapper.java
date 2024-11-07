package com.rafaelsaca.cardapio.mappers;

import com.rafaelsaca.cardapio.dtos.PedidoDto;
import com.rafaelsaca.cardapio.models.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PedidoMapper {
    private final ModelMapper mapper;

    public PedidoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public PedidoDto toDto (Pedido pedido){
        return mapper.map(pedido,PedidoDto.class);
    }

    public Pedido toEntity (PedidoDto pedidoDto){
        return mapper.map(pedidoDto,Pedido.class);
    }

    public List<PedidoDto> toListDto (List<Pedido> pedidos){
        return pedidos.stream().map(pedido -> mapper.map(pedido,PedidoDto.class))
                .collect(Collectors.toList());
    }
}
