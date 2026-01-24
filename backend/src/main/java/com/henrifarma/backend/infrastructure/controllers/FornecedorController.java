package com.henrifarma.backend.infrastructure.controllers;

import com.henrifarma.backend.infrastructure.models.Fornecedor;
import com.henrifarma.backend.infrastructure.services.FornecedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("fornecedores", fornecedorService.listar());
        model.addAttribute("fornecedor", new Fornecedor());
        return "fornecedores";
    }

    @PostMapping("/salvar")
    public String salvarOuEditar(@ModelAttribute Fornecedor fornecedor) {
        fornecedorService.salvarOuAtualizar(fornecedor);
        return "redirect:/fornecedores";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("fornecedor", fornecedorService.buscarPorId(id));
        model.addAttribute("fornecedores", fornecedorService.listar());
        return "fornecedores";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        fornecedorService.remover(id);
        return "redirect:/fornecedores";
    }
}