package com.example.apiRestfulprojetosOrla.orm;

import com.example.apiRestfulprojetosOrla.model.CPF;
import com.example.apiRestfulprojetosOrla.model.Email;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

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
    private CPF cpf;
    private Email email;
    private BigDecimal salario;
}