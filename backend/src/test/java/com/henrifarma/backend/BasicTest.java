package com.henrifarma.backend;

import com.henrifarma.backend.infrastructure.models.Cargos;
import com.henrifarma.backend.infrastructure.models.Funcionario;
import com.henrifarma.backend.infrastructure.services.ClienteService;
import org.junit.jupiter.api.Test;
import com.henrifarma.backend.infrastructure.models.Cliente;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class BasicTest {
    @Autowired
    private ClienteService clienteService;

    @Test
    void createCliente() {
        Cliente c = new Cliente();
        c.setCpf("677.091.060-80");
        c.setEndereco("Rua 1");
        c.setNome("Henrique");
        c.setTelefone("11999999999");
        clienteService.salvarOuAtualizar(c);
    }
}
