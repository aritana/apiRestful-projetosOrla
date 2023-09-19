package com.example.apiRestfulprojetosOrla.service;

import com.example.apiRestfulprojetosOrla.orm.Projeto;
import com.example.apiRestfulprojetosOrla.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProjetoService {

    private final ProjetoRepository repository;

    @Autowired
    public ProjetoService(ProjetoRepository repository) {
        this.repository = repository;
    }
    public Projeto criarProjeto(Projeto projeto) {
        return repository.save(projeto);
    }
    public Projeto encontrarProjetoPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new NoSuchElementException("Projeto não encontrado"));
    }
    public List<Projeto> listarTodosFuncionarios(){
        Iterable<Projeto> projetoIterable =  repository.findAll();
        List<Projeto> projetos = new ArrayList<>();
        projetoIterable.forEach(projetos::add);
        return projetos;
    }
    public void deletarProjeto(Long id){
        repository.deleteById(id);
    }
}