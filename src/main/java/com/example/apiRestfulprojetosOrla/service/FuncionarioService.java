package com.example.apiRestfulprojetosOrla.service;

import com.example.apiRestfulprojetosOrla.dto.FuncionarioDto;
import com.example.apiRestfulprojetosOrla.model.FuncionarioModel;
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

    public FuncionarioDto criarFuncionario(FuncionarioModel funcionarioModel) {

        Funcionario funcionario = repository.save(funcionarioModel.toEntity());
        FuncionarioDto funcionarioDto = toDto(funcionario);
        return  funcionarioDto;
    }

    public FuncionarioDto encontrarFuncionarioPorId(Long id) {
        Funcionario funcionario =  repository.findById(id).orElseThrow(() -> new NoSuchElementException("Funcionario não encontrado"));
        FuncionarioDto funcionarioDto = toDto(funcionario);
        return  funcionarioDto;
    }

    public List<FuncionarioDto> listarTodosFuncionarios() {
        Iterable<Funcionario> funcionariosIterable = repository.findAll();
        List<FuncionarioDto> funcionarios = new ArrayList<>();

        for (Funcionario funcionario : funcionariosIterable){
            funcionarios.add(toDto(funcionario));
        }
        return funcionarios;
    }

    public void deletarFuncionario(Long id) {
        repository.deleteById(id);
    }

    public FuncionarioDto toDto(Funcionario funcionario){
        FuncionarioDto funcionarioDto = FuncionarioDto.builder()
                .nome(funcionario.getNome())
                .cpf(funcionario.getCpf().getNumber())
                .email(funcionario.getEmail().getEndereco())
                .salario(funcionario.getSalario().toString())
                .build();
        return  funcionarioDto;
    }
}