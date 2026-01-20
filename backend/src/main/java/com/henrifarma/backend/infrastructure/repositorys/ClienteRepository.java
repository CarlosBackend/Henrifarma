package com.henrifarma.backend.infrastructure.repositorys;

import com.henrifarma.backend.infrastructure.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Buscar cliente pelo CPF
    Optional<Cliente> findByCpf(String cpf);

    // Buscar cliente pelo nome
    Optional<Cliente> findByNome(String nome);

    // Buscar cliente pelo telefone
    Optional<Cliente> findByTelefone(String telefone);
}

