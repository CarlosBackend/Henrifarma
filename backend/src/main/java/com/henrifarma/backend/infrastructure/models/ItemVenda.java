package com.henrifarma.backend.infrastructure.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "itens_venda")
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantidade;
    private Double valor;
    @ManyToOne
    private Produto produto;
    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;
}
