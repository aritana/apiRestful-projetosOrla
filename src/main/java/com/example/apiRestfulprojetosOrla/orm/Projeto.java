package com.example.apiRestfulprojetosOrla.orm;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name =  "projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private LocalDate  data_criacao;

    @ManyToMany(mappedBy = "projetos")
    private Set<Funcionario> funcionarios = new HashSet<>();
}
