package com.henrifarma.backend.infrastructure.services;

import com.henrifarma.backend.infrastructure.models.Fornecedor;
import com.henrifarma.backend.infrastructure.repositorys.FornecedorRepository;
import org.springframework.stereotype.Service;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public void salvarOuAtualizar(Fornecedor fornecedor) {
        fornecedorRepository.save(fornecedor);
    }
    public Fornecedor buscarPorId(Long id) {
        return fornecedorRepository.findById(id).orElse(null);
    }
    public void remover(Long id) {
        fornecedorRepository.deleteById(id);
    }
    public Iterable<Fornecedor> listar() {
        return fornecedorRepository.findAll();
    }
}
