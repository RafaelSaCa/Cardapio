package com.rafaelsaca.cardapio.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rafaelsaca.cardapio.dtos.UsuarioDto;
import com.rafaelsaca.cardapio.exceptions.RecursoNotFoundException;
import com.rafaelsaca.cardapio.mappers.UsuarioMapper;
import com.rafaelsaca.cardapio.models.Usuario;
import com.rafaelsaca.cardapio.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioMapper mapper, PasswordEncoder passwordEncoder, UsuarioRepository repository) {
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }
    

    @Transactional
    public UsuarioDto cadastra (UsuarioDto usuarioDto){

        Usuario usuarioExistente = repository.findByTelefone(usuarioDto.getTelefone());

        if (usuarioExistente != null){
            throw new RecursoNotFoundException("Usuário já existe!");
        }

        usuarioDto.setSenha(passwordEncoder.encode(usuarioDto.getSenha()));
    
        Usuario usuario = mapper.toEntity(usuarioDto);
        Usuario usuarioSalvo = repository.save(usuario);

        return mapper.toDto(usuarioSalvo);
    }

    public List<UsuarioDto> lista (){
        List<Usuario> usuarios = repository.findAll();

        return mapper.toListDto(usuarios);
    }

    public UsuarioDto busca (Long id){
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RecursoNotFoundException("Usuário não encontrado!"));

        return mapper.toDto(usuario);
    }

    @Transactional
    public UsuarioDto atualiza (Long id, UsuarioDto usuarioDto){
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RecursoNotFoundException("Usuário não encontrado!"));

        usuario.setNome(usuarioDto.getNome());
        usuario.setTelefone(usuarioDto.getTelefone());
        usuario.setSenha(usuarioDto.getSenha());

        Usuario usuarioSalvo = repository.save(usuario);
        return mapper.toDto(usuarioSalvo);
    }

    @Transactional
    public void remove (Long id){
        if (!repository.existsById(id)){
            throw new RecursoNotFoundException("Usuário não encontrado!");
        }

        repository.deleteById(id);

    }
}
