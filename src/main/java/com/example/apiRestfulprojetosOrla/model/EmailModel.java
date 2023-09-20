package com.example.apiRestfulprojetosOrla.model;

import com.example.apiRestfulprojetosOrla.orm.Email;
import lombok.Getter;
@Getter
public class EmailModel {

    private String endereco;
    public EmailModel(String endereco) {
        if (endereco == null || !endereco.matches(
                "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            throw new IllegalArgumentException("Invalid e-mail!");
        }
        this.endereco = endereco;
    }

    public Email toEntity() {
        Email email = new Email();
        email.setEndereco(this.endereco);
        return  email;
    }
}