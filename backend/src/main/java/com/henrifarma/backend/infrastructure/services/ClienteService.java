package com.henrifarma.backend.infrastructure.services;

import com.henrifarma.backend.infrastructure.models.Cliente;
import com.henrifarma.backend.infrastructure.repositorys.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente salvarOuAtualizar(Cliente cliente) {
        if (cliente.getId() != null) {
            // Atualiza cliente existente
            Cliente existente = clienteRepository.findById(cliente.getId())
                    .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));
            existente.setNome(cliente.getNome());
            existente.setCpf(cliente.getCpf());
            existente.setEndereco(cliente.getEndereco());
            existente.setTelefone(cliente.getTelefone());
            return clienteRepository.save(existente);
        }
        // Cria novo cliente
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));
    }

    public void remover(Long id) {
        clienteRepository.deleteById(id);
    }

}
