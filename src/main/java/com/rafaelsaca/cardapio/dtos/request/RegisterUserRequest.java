package com.rafaelsaca.cardapio.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequest {

  private String nome;
  private String email;
  private String senha;
  
}