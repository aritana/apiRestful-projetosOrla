package com.example.apiRestfulprojetosOrla.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjetoModel {
    private String nome;
    private LocalDate data_criacao;
}
