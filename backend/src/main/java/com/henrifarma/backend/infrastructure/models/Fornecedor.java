package com.henrifarma.backend.infrastructure.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "fornecedores")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "PessoaContato")
    private String pessoaContato;
    @Column(name = "telefone")
    private String telefone;
}
