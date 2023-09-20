package com.example.apiRestfulprojetosOrla.model;

import com.example.apiRestfulprojetosOrla.orm.Funcionario;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuncionarioModel {
    private String nome;
    private CPFModel cpf;
    private EmailModel email;
    private BigDecimal salario;
}