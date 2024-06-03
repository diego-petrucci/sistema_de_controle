package com.example.sistema.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.models.Entrada;


public interface  EntradaRepository extends JpaRepository<Entrada, Long>{
}
