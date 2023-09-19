package com.example.apiRestfulprojetosOrla.model;

import lombok.Getter;

@Getter
public class CPF {
    private String number;

    public CPF(String value) {
        if (value == null || !value.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}"))
            throw new IllegalArgumentException("Invalid CPF");
        this.number = value;
    }
}