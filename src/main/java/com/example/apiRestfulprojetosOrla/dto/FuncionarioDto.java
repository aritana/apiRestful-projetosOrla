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
    @NotEmpty(message = "O campo Nome não pode ser vazio.")
    @NotNull(message = "O campo nome não pode ser nulo.")
    private String nome;
    @NotEmpty(message = "O campo CPF não pode ser vazio.")
    @NotNull(message = "O campo CPF não pode ser nulo.")
    private String cpf;
    @NotEmpty(message = "O campo E-mail não pode ser vazio.")
    @NotNull(message = "O campo E-mail não pode ser nulo.")
    private String email;
    @NotEmpty(message = "O campo Salário não pode ser vazio.")
    @NotNull(message = "O campo Salário não pode ser nulo.")
    private String salario;
    private String id;
}
