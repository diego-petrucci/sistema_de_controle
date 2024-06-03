package com.example.sistema.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.models.Produto;


public interface  ProdutoRepository extends JpaRepository<Produto, Long>{
}
