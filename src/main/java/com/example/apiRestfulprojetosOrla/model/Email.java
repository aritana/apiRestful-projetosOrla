package com.example.apiRestfulprojetosOrla.model;

import lombok.Getter;

public class Email {

    @Getter
    private String address;

    public Email(String endereco) {
        if (endereco == null || !endereco.matches(
                "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid e-mail!");
        }
        this.address = endereco;
    }
}