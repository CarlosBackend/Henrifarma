package com.henrifarma.backend.infrastructure.controllers;

import com.henrifarma.backend.infrastructure.models.Cliente;
import com.henrifarma.backend.infrastructure.models.ItemVenda;
import com.henrifarma.backend.infrastructure.models.Produto;
import com.henrifarma.backend.infrastructure.models.Venda;
import com.henrifarma.backend.infrastructure.services.ClienteService;
import com.henrifarma.backend.infrastructure.services.ProdutoService;
import com.henrifarma.backend.infrastructure.services.VendaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/vendas")
public class VendaController {
    private final VendaService vendaService;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    public VendaController(VendaService vendaService, ClienteService clienteService, ProdutoService produtoService) {
        this.vendaService = vendaService;
        this.clienteService = clienteService;
        this.produtoService = produtoService;
    }
    @GetMapping
    public String listar(Model model) {
        Venda venda = new Venda();
        if (venda.getItens() == null || venda.getItens().isEmpty()) {
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setProduto(new Produto());
            venda.setItens(new ArrayList<>());
        }
        venda.setCliente(new Cliente());
        model.addAttribute("venda", venda);
        model.addAttribute("vendas", vendaService.listar());
        model.addAttribute("clientes", clienteService.listar());
        model.addAttribute("produtos", produtoService.listar());
        return "vendas";
    }
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Venda venda) {
        vendaService.salvarOuAtualizar(venda);
        return "redirect:/vendas";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("venda", vendaService.buscarPorId(id));
        model.addAttribute("vendas", vendaService.listar());
        return "vendas";
    }
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        vendaService.remover(id);
        return "redirect:/vendas";
    }
}
