package com.example.apiRestfulprojetosOrla.service;

import com.example.apiRestfulprojetosOrla.orm.Funcionario;
import com.example.apiRestfulprojetosOrla.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    @Autowired
    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public Funcionario criarFuncionario(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public Funcionario encontrarFuncionarioPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new NoSuchElementException("Funcionario não encontrado"));
    }

    public List<Funcionario> listarTodosFuncionarios(){
        Iterable<Funcionario> funcionariosIterable =  repository.findAll();
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionariosIterable.forEach(funcionarios::add);
        return funcionarios;
    }

    public void deletarFuncionario(Long id){
        repository.deleteById(id);
    }
}