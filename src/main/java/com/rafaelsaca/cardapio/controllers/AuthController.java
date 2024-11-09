package com.rafaelsaca.cardapio.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rafaelsaca.cardapio.dtos.request.AuthRequest;
import com.rafaelsaca.cardapio.dtos.response.AuthResponse;
import com.rafaelsaca.cardapio.models.User;
import com.rafaelsaca.cardapio.services.TokenService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        UsernamePasswordAuthenticationToken usuarioEsenha = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usuarioEsenha);

        User usuario = (User) authenticate.getPrincipal();

        String token = tokenService.geraToken(usuario);

        return ResponseEntity.ok(AuthResponse.builder()
                .acessToken(token)
                .nome(usuario.getName())
                .build());

    }

}
