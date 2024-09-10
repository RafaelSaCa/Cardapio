package com.rafaelsaca.cardapio.repositories;

import com.rafaelsaca.cardapio.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
