package com.henrifarma.backend.infrastructure.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "preco")
    private Double preco;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "validade")
    private LocalDate validade;
}
