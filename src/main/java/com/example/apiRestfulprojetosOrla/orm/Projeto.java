package com.example.apiRestfulprojetosOrla.orm;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name =  "projeto")
@Getter
@Setter
@NoArgsConstructor
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate  data_criacao;
    @ManyToMany(mappedBy = "projetos")
    private Set<Funcionario> funcionarios = new HashSet<>();
}