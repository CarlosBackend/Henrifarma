package com.henrifarma.backend.infrastructure.controllers;
import com.henrifarma.backend.infrastructure.models.Produto;
import com.henrifarma.backend.infrastructure.services.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("produtos", produtoService.listar());
        model.addAttribute("produto", new Produto());
        return "produtos"; // retorna produtos.html
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Produto produto) {
        produtoService.salvar(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("produto", produtoService.buscarPorId(id));
        model.addAttribute("produtos", produtoService.listar());
        return "produtos"; // renderiza a mesma página com form preenchido
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        produtoService.remover(id);
        return "redirect:/produtos";
    }

}
