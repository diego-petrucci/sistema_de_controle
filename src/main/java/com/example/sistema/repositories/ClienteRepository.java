package com.example.sistema.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
