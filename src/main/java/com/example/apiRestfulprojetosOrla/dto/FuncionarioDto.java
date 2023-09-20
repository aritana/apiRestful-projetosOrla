package com.example.apiRestfulprojetosOrla.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuncionarioDto {
    @NotEmpty
    @NotNull
    private String nome;
    @NotEmpty
    @NotNull
    private String cpf;
    @NotEmpty
    @NotNull
    private String email;
    @NotEmpty
    @NotNull
    private String salario;
    private String id;
}
