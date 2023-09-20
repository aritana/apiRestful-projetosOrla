package com.example.apiRestfulprojetosOrla.controller;

import com.example.apiRestfulprojetosOrla.dto.FuncionarioDto;
import com.example.apiRestfulprojetosOrla.model.CPFModel;
import com.example.apiRestfulprojetosOrla.model.EmailModel;
import com.example.apiRestfulprojetosOrla.model.FuncionarioModel;
import com.example.apiRestfulprojetosOrla.service.FuncionarioService;
import io.swagger.annotations.Api;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Api(value = "API para gerenciar projetos")
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    @Transactional
    public FuncionarioDto criarFuncionario(@RequestBody @Valid FuncionarioDto funcionarioDto) {

        FuncionarioModel funcionarioModel = FuncionarioModel.builder()
                .nome(funcionarioDto.getNome())
                .email(new EmailModel(funcionarioDto.getEmail()))
                .cpf(new CPFModel(funcionarioDto.getCpf()))
                .salario(new BigDecimal(funcionarioDto.getSalario()))
                .build();

        return funcionarioService.criarFuncionario(funcionarioModel);
    }

    @GetMapping("/{id}")
    public FuncionarioDto encontrarFuncionarioPorId(@PathVariable Long id) {
        return funcionarioService.encontrarFuncionarioPorId(id);
    }

    @GetMapping
    public List<FuncionarioDto> listarTodosFuncionarios() {
        return funcionarioService.listarTodosFuncionarios();
    }

    @DeleteMapping("/{id}")
    public void deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletarFuncionario(id);
    }
}