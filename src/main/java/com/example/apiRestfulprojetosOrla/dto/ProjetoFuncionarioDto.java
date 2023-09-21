package com.example.apiRestfulprojetosOrla.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjetoFuncionarioDto {
    @NotEmpty(message = "O campo idFuncionario não pode ser vazio.")
    @NotNull(message = "O campo idFuncionario não pode ser nulo.")
    private String idFuncionario;
    @NotEmpty(message = "O campo idProjeto não pode ser vazio.")
    @NotNull(message = "O campo idProjeto não pode ser nulo.")
    private String idProjeto;
}