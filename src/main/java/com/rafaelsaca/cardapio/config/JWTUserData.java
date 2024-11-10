package com.rafaelsaca.cardapio.config;

import java.util.List;

import com.rafaelsaca.cardapio.enums.Role;

import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class JWTUserData {

  private String usuarioId;
  private String email;
  private List<Role> roles;
  
}
