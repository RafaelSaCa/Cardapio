package com.rafaelsaca.cardapio.dtos;


import com.rafaelsaca.cardapio.enums.Role;

import jakarta.validation.constraints.NotBlank;

public class UsuarioDto {

    private Long id;
    @NotBlank(message = "Nome é obrigatório!")
    private String nome;
    @NotBlank(message = "Telefone é obrigatório!")
    private String telefone;
    @NotBlank(message = "Senha é obrigatória!")
    private String senha;
    
    private Role role;

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Nome é obrigatório!")
    String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório!") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Telefone é obrigatório!")
    String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "Telefone é obrigatório!") String telefone) {
        this.telefone = telefone;
    }

    public @NotBlank(message = "Senha é obrigatória!")
    String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "Senha é obrigatória!") String senha) {
        this.senha = senha;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
