package com.henrifarma.backend.infrastructure.services;

import com.henrifarma.backend.infrastructure.models.Venda;
import com.henrifarma.backend.infrastructure.repositorys.VendaReposiroty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {
    private final VendaReposiroty vendaReposiroty;

    public VendaService(VendaReposiroty vendaReposiroty) {
        this.vendaReposiroty = vendaReposiroty;
    }
    public List<Venda> listar() {
        return vendaReposiroty.findAll();
    }

    public Venda buscarPorId(Long id) {
        return vendaReposiroty.findById(id).orElse(null);
    }

    public void salvarOuAtualizar(Venda venda) {
        vendaReposiroty.save(venda);
    }

    public void remover(Long id) {
        vendaReposiroty.deleteById(id);
    }

}
