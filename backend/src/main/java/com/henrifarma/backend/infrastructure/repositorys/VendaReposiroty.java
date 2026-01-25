package com.henrifarma.backend.infrastructure.repositorys;

import com.henrifarma.backend.infrastructure.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaReposiroty extends JpaRepository<Venda, Long> {
}
