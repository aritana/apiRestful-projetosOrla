package com.example.apiRestfulprojetosOrla.service;

import com.example.apiRestfulprojetosOrla.orm.Funcionario;
import com.example.apiRestfulprojetosOrla.orm.Projeto;
import com.example.apiRestfulprojetosOrla.repository.FuncionarioRepository;
import com.example.apiRestfulprojetosOrla.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;

@Service
public class ProjetoFuncionarioService {
    private final ProjetoRepository projetoRepository;
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public ProjetoFuncionarioService(ProjetoRepository projetoRepositorio, FuncionarioRepository funcionarioRepositorio) {
        this.projetoRepository = projetoRepositorio;
        this.funcionarioRepository = funcionarioRepositorio;
    }
    public boolean vincularFuncionarioProjeto(Long idProjeto, Long idFuncionario) {

        Projeto projetoPersistido = projetoRepository.findById(idProjeto).orElseThrow(() -> new NoSuchElementException("Projeto não encontrado"));
        Funcionario funcionarioPersistido = funcionarioRepository.findById(idFuncionario).orElseThrow(() -> new NoSuchElementException("Funcionario não encontrado"));

        projetoPersistido.getFuncionarios().add(funcionarioPersistido);
        funcionarioPersistido.getProjetos().add(projetoPersistido);

        Projeto projeto = projetoRepository.save(projetoPersistido);
        Funcionario funcionario = funcionarioRepository.save(funcionarioPersistido);

        if (projeto.getId() != null && funcionario.getId() !=null) {
            return true;
        }
        return false;
    }
    private LocalDate stringToLocalDate(String dataString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = null;
        try {
            localDate = LocalDate.parse(dataString, formatter);

        } catch (java.time.format.DateTimeParseException e) {
            System.err.println("Invalid date format");
        }
        return localDate;
    }
}