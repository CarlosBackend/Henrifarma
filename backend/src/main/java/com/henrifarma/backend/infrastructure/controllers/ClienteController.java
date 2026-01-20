package com.henrifarma.backend.infrastructure.controllers;

import com.henrifarma.backend.infrastructure.models.Cliente;
import com.henrifarma.backend.infrastructure.services.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Listar clientes e carregar formulário
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", clienteService.listar());
        model.addAttribute("cliente", new Cliente()); // objeto vazio para o form
        return "clientes"; // retorna clientes.html
    }

    // Salvar novo cliente
    @PostMapping
    public String salvar(@ModelAttribute Cliente cliente) {
        clienteService.salvarOuAtualizar(cliente);
        return "redirect:/clientes";
    }

    // Editar cliente
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("cliente", clienteService.buscarPorId(id));
        model.addAttribute("clientes", clienteService.listar());
        return "/clientes";
    }

    // Deletar cliente
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        clienteService.remover(id);
        return "redirect:/clientes";
    }
}