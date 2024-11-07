package com.rafaelsaca.cardapio.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.rafaelsaca.cardapio.dtos.UsuarioDto;
import com.rafaelsaca.cardapio.models.Usuario;

@Component
public class UsuarioMapper {
    private final ModelMapper mapper;

    public UsuarioMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public UsuarioDto toDto (Usuario usuario){
        return mapper.map(usuario,UsuarioDto.class);
    }

    public Usuario toEntity (UsuarioDto usuarioDto){
        return mapper.map(usuarioDto,Usuario.class);
    }

    public List<UsuarioDto> toListDto (List<Usuario> usuarios){
        return usuarios.stream().map(usuario -> mapper.map(usuario,UsuarioDto.class))
                .collect(Collectors.toList());
    }
}
