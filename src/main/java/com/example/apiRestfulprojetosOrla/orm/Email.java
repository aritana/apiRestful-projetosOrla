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
    private String endereco;
    @OneToOne(mappedBy = "email")
    private Funcionario funcionario;}