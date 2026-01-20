package com.henrifarma.backend.infrastructure.services;

import com.henrifarma.backend.infrastructure.models.Funcionario;
import com.henrifarma.backend.infrastructure.repositorys.FuncionarioRepository;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }
    public void salvarOuAtualizar(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }
    public Funcionario buscarPorId(Long id) {
        return funcionarioRepository.findById(id).orElse(null);
    }
    public void remover(Long id) {
        funcionarioRepository.deleteById(id);
    }
    public Iterable<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }
}
