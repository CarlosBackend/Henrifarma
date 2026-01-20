package com.henrifarma.backend.infrastructure.repositorys;

import com.henrifarma.backend.infrastructure.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
