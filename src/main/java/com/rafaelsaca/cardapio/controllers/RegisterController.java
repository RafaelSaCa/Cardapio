package com.rafaelsaca.cardapio.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelsaca.cardapio.dtos.request.RegisterUserRequest;
import com.rafaelsaca.cardapio.enums.Role;
import com.rafaelsaca.cardapio.models.User;
import com.rafaelsaca.cardapio.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
public class RegisterController {

  private final UserRepository repository;

  @PostMapping
  public ResponseEntity<Void> register (@RequestHeader(value="isAdmin", required=false) boolean isAdmin, 
                                        @RequestBody RegisterUserRequest request ){

      User newUser = User.builder()
              .name(request.getNome())
              .email(request.getEmail())
              .roles(isAdmin ? List.of( Role.ADMIN, Role.USER) : List.of(Role.USER))
                .password( new BCryptPasswordEncoder().encode(request.getSenha()))
                .build();

      repository.save(newUser);

      return ResponseEntity.status(HttpStatus.CREATED).build();
  }
  
}
