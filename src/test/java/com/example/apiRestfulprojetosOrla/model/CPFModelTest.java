package com.example.apiRestfulprojetosOrla.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CPFModelTest {
    @Test
    void shouldNotCreateCPFWithWrongValue() {
        assertThrows(IllegalArgumentException.class, () -> new CPFModel(null));
        assertThrows(IllegalArgumentException.class, () -> new CPFModel(""));
        assertThrows(IllegalArgumentException.class, () -> new CPFModel("123.222.222"));
    }

    @Test
    void shouldCreateCPFWithCorrectValue() {
        String number = "023.067.484-48";
        CPFModel cpfModel = new CPFModel(number);
        assertEquals(number, cpfModel.getNumber());
    }
}