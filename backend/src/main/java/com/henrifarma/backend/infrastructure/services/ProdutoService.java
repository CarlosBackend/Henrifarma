package com.henrifarma.backend.infrastructure.services;

import com.henrifarma.backend.infrastructure.models.Produto;
import com.henrifarma.backend.infrastructure.repositorys.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void salvar(Produto produto) {
        produtoRepository.save(produto);
    }
    public void remover(Long id) {
        produtoRepository.deleteById(id);
    }
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }
    public void delete(Produto produto) {
        produtoRepository.delete(produto);
    }
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }
}
