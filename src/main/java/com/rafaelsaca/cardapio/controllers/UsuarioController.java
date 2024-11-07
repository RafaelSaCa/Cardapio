package com.rafaelsaca.cardapio.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelsaca.cardapio.dtos.UsuarioDto;
import com.rafaelsaca.cardapio.services.UsuarioService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsuarioDto> cadastraUsuario (@RequestBody UsuarioDto usuarioDto){
        UsuarioDto usuario = service.cadastra(usuarioDto);

        return ResponseEntity.ok(usuario);
    }

    @GetMapping()
    public ResponseEntity<List<UsuarioDto>> listaUsuarios (){
        List<UsuarioDto> usuarios = service.lista();

        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> buscaUsuario (@PathVariable Long id){
        UsuarioDto usuario = service.busca(id);

        return ResponseEntity.ok(usuario);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDto> atualizaUsuario (@PathVariable Long id, @RequestBody UsuarioDto usuarioDto){
        UsuarioDto usuarioAtualizado = service.atualiza(id, usuarioDto);

        return ResponseEntity.ok(usuarioAtualizado);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeUsuario (@PathVariable Long id){
        service.remove(id);

        return ResponseEntity.noContent().build();
    }
}
