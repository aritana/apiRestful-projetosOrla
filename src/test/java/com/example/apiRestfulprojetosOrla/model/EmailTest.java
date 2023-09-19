package com.example.apiRestfulprojetosOrla.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void shouldNotCreateEmailsWithWrongAddress(){
        assertThrows(IllegalArgumentException.class,()-> new Email(null));
        assertThrows(IllegalArgumentException.class,()-> new Email(""));
        assertThrows(IllegalArgumentException.class,()-> new Email("invalide-mail"));
    }

    @Test
    void shouldCreateEmailsWithCorrectAddress(){
        String address = "fulano@gmail.com";
        Email email =  new Email(address);
        assertEquals(address,email.getAddress());
    }

}