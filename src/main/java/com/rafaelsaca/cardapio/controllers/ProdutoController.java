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

import com.rafaelsaca.cardapio.dtos.ProdutoDto;
import com.rafaelsaca.cardapio.services.ProdutoService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/api/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<ProdutoDto> cadastraProduto (@RequestBody ProdutoDto produtoDto){
        ProdutoDto produtoSalvo = service.cadastraProduto(produtoDto);

        return ResponseEntity.ok(produtoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> listaProdutos (){
        List<ProdutoDto> produtos = service.listaProdutos();

        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> buscarProduto (@PathVariable Long id){
        ProdutoDto produto = service.buscaProduto(id);
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDto> atualizaProduto (@PathVariable Long id,@RequestBody ProdutoDto produtoDto){
        ProdutoDto produto = service.atualizarProduto(id, produtoDto);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeProduto (@PathVariable Long id){
        service.removeProduto(id);

        return ResponseEntity.noContent().build();
    }


}
