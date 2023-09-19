package com.example.apiRestfulprojetosOrla.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFTest {
    @Test
    void shouldNotCreateCPFWithWrongValue() {
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));
        assertThrows(IllegalArgumentException.class, () -> new CPF(""));
        assertThrows(IllegalArgumentException.class, () -> new CPF("123.222.222"));
    }

    @Test
    void shouldCreateCPFWithCorrectValue() {
        String number = "023.067.484-48";
        CPF cpf = new CPF(number);
        assertEquals(number, cpf.getNumber());
    }
}