package com.example.sistema.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.models.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{
}
