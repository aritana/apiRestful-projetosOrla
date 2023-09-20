package com.example.apiRestfulprojetosOrla.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjetoDto {
    @NotEmpty
    @NotNull
    private String nome;
    private String data_criacao;
    private String id;
}