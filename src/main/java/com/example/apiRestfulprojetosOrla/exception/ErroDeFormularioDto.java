package com.example.apiRestfulprojetosOrla.exception;

import lombok.*;

@Getter
@Setter
public class ErroDeFormularioDto {
    private String campo;
    private String erro;

    public ErroDeFormularioDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }
}