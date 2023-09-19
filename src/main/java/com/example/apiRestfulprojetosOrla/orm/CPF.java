package com.example.apiRestfulprojetosOrla.orm;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cpf")
@Getter
@Setter
@NoArgsConstructor
public class CPF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;

    @OneToOne
    @JoinColumn(name = "funcionario_id") // Defines the foreign key column in the address table
    private Funcionario funcionario;
}