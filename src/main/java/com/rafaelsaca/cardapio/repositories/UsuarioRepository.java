package com.rafaelsaca.cardapio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelsaca.cardapio.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByTelefone(String telefone);
}
