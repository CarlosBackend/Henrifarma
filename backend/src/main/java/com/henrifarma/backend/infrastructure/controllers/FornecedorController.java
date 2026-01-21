package com.henrifarma.backend.infrastructure.controllers;


import com.henrifarma.backend.infrastructure.models.Cliente;
import com.henrifarma.backend.infrastructure.models.Fornecedor;
import com.henrifarma.backend.infrastructure.services.FornecedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
