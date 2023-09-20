package com.example.apiRestfulprojetosOrla.model;

import com.example.apiRestfulprojetosOrla.orm.CPF;
import com.example.apiRestfulprojetosOrla.orm.Funcionario;
import lombok.Getter;

@Getter
public class CPFModel {
    private String number;

    public CPFModel(String value) {
        if (value == null || !value.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}"))
            throw new IllegalArgumentException("Invalid CPF");
        this.number = value;
    }

    public CPF toEntity() {
        CPF cpf = new CPF();
        cpf.setNumber(this.number);
        return cpf;
    }
}