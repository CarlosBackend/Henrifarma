package com.henrifarma.backend.infrastructure.controllers;

import com.henrifarma.backend.infrastructure.models.Funcionario;
import com.henrifarma.backend.infrastructure.services.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
