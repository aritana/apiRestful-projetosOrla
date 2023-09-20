package com.example.apiRestfulprojetosOrla.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailModelTest {

    @Test
    void shouldNotCreateEmailsWithWrongAddress(){
        assertThrows(IllegalArgumentException.class,()-> new EmailModel(null));
        assertThrows(IllegalArgumentException.class,()-> new EmailModel(""));
        assertThrows(IllegalArgumentException.class,()-> new EmailModel("invalide-mail"));
    }

    @Test
    void shouldCreateEmailsWithCorrectAddress(){
        String address = "fulano@gmail.com";
        EmailModel emailModel =  new EmailModel(address);
        assertEquals(address, emailModel.getEndereco());
    }
}