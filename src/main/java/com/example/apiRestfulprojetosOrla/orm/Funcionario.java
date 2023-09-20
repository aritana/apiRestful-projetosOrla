package com.example.apiRestfulprojetosOrla.orm;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "funcionario")
@Getter
@Setter
@NoArgsConstructor
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "cpf_id", referencedColumnName = "id")
    private CPF cpf;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "email_id", referencedColumnName = "id")
    private Email email;
    private BigDecimal salario;

    @ManyToMany(mappedBy = "funcionarios")
    private Set<Projeto> projetos = new HashSet<>();}