package com.rafaelsaca.cardapio.dtos.request;

import lombok.Data;

@Data
public class AuthRequest {
  
  public String username;
  public String password;
}
