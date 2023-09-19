package com.example.apiRestfulprojetosOrla.controller;

import com.example.apiRestfulprojetosOrla.model.CPF;
import com.example.apiRestfulprojetosOrla.service.CPFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cpfs")
public class CPFController {

    private final CPFService cpfService;

    @Autowired
    public CPFController(CPFService cpfService) {
        this.cpfService = cpfService;
    }

    @PostMapping
    public CPF criarCPF(@RequestBody CPF cpf) {
        return cpfService.criarCPF(cpf);
    }

    @GetMapping("/{id}")
    public CPF encontrarCPFPorId(@PathVariable Long id) {
        return cpfService.encontrarCPFPorId(id);
    }

    @GetMapping
    public List<CPF> listarTodosCPFs() {
        return cpfService.listarTodosCPFs();
    }

    @DeleteMapping("/{id}")
    public void deletarCPF(@PathVariable Long id) {
        cpfService.deletarCPF(id);
    }

}
