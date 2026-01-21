package com.henrifarma.backend.infrastructure.repositorys;

import com.henrifarma.backend.infrastructure.models.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
}
