package com.henrifarma.backend.infrastructure.controllers;

import com.henrifarma.backend.infrastructure.models.Funcionario;
import com.henrifarma.backend.infrastructure.services.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }
    @GetMapping
    public String listar(Model model){
        model.addAttribute("funcionarios", funcionarioService.listar());
        model.addAttribute("funcionario", new Funcionario());
        return "funcionarios";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model){
        model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
        model.addAttribute("funcionarios", funcionarioService.listar());
        return "funcionarios";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id){
        funcionarioService.remover(id);
        return "redirect:/funcionarios";
    }
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Funcionario funcionario){
        funcionarioService.salvarOuAtualizar(funcionario);
        return "redirect:/funcionarios";
    }
}
