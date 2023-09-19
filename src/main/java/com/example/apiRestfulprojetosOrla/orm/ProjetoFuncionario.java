package com.example.apiRestfulprojetosOrla.orm;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "projeto_funcionario")
@Getter
@Setter
@NoArgsConstructor
public class ProjetoFuncionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
}