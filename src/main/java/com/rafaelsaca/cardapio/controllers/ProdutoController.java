package com.rafaelsaca.cardapio.controllers;

import com.rafaelsaca.cardapio.dtos.ProdutoDto;
import com.rafaelsaca.cardapio.mappers.ProdutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rafaelsaca.cardapio.services.ProdutoService;

import java.util.List;

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
