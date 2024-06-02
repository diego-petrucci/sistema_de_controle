package com.example.sistema.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sistema.models.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
}
