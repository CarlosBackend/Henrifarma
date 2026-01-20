package com.henrifarma.backend.infrastructure.repositorys;

import com.henrifarma.backend.infrastructure.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
