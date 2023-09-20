package com.example.apiRestfulprojetosOrla.controller;

import com.example.apiRestfulprojetosOrla.dto.FuncionarioDto;
import com.example.apiRestfulprojetosOrla.model.CPFModel;
import com.example.apiRestfulprojetosOrla.model.EmailModel;
import com.example.apiRestfulprojetosOrla.model.FuncionarioModel;
import com.example.apiRestfulprojetosOrla.service.FuncionarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;
    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<FuncionarioDto> criarFuncionario(@RequestBody @Valid FuncionarioDto funcionarioDto) {
        FuncionarioModel funcionarioModel = FuncionarioModel.builder()
                .nome(funcionarioDto.getNome())
                .email(new EmailModel(funcionarioDto.getEmail()))
                .cpf(new CPFModel(funcionarioDto.getCpf()))
                .salario(new BigDecimal(funcionarioDto.getSalario()))
                .build();

        FuncionarioDto funcionario = funcionarioService.criarFuncionario(funcionarioModel);
        return new ResponseEntity(funcionario, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDto> encontrarFuncionarioPorId(@PathVariable Long id) {
        FuncionarioDto funcionario = funcionarioService.encontrarFuncionarioPorId(id);
        return new ResponseEntity(funcionario, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDto>> listarTodosFuncionarios() {
        List<FuncionarioDto> funcionariosDto = funcionarioService.listarTodosFuncionarios();
        return new ResponseEntity<>(funcionariosDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        boolean foiDeletadoComSucesso = funcionarioService.deletarFuncionario(id);
        if(foiDeletadoComSucesso){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}