package com.example.apiRestfulprojetosOrla.service;

import com.example.apiRestfulprojetosOrla.orm.CPF;
import com.example.apiRestfulprojetosOrla.repository.CPFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CPFService {

    private CPFRepository repository;

    @Autowired
    public CPFService(CPFRepository repository) {
        this.repository = repository;
    }

    public CPF criarCPF(CPF cpf) {
        return repository.save(cpf);
    }

    public CPF encontrarCPFPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new NoSuchElementException("CPF não encontrado"));
    }

    public List<CPF> listarTodosCPFs(){
        Iterable<CPF> cpfIterable =  repository.findAll();
        List<CPF> cpfList = new ArrayList<>();
        cpfIterable.forEach(cpfList::add);
        return cpfList;
    }

    public void deletarCPF(Long id){
        repository.deleteById(id);
    }
}
