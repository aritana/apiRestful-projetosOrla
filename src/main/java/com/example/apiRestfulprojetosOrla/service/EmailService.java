package com.example.apiRestfulprojetosOrla.service;

import com.example.apiRestfulprojetosOrla.orm.Email;
import com.example.apiRestfulprojetosOrla.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmailService {

    private final EmailRepository repositorio;

    @Autowired
    public EmailService(EmailRepository repositorio) {
        this.repositorio = repositorio;
    }

    public Email criarEmail(Email email) {
        return repositorio.save(email);
    }

    public Email encontrarEmailPorId(Long id){
        return repositorio.findById(id).orElseThrow(()-> new NoSuchElementException("E-mail não encontrado"));
    }

    public List<Email> listarTodosEmails(){
        Iterable<Email> emailIterable =  repositorio.findAll();
        List<Email> emails = new ArrayList<>();
        emailIterable.forEach(emails::add);
        return emails;
    }

    public void deletarEmail(Long id){
        repositorio.deleteById(id);
    }
}