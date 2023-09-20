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
    @NotEmpty(message = "O campo Nome não pode ser vazio.")
    @NotNull(message = "O campo Nome não pode ser nulo.")
    private String nome;
    private String data_criacao;
    private String id;
}