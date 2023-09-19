package com.example.apiRestfulprojetosOrla.orm;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "email")
@Getter
@Setter
@NoArgsConstructor
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;

    @OneToOne
    @JoinColumn(name = "funcionario_id") // Defines the foreign key column in the address table
    private Funcionario funcionario;
}