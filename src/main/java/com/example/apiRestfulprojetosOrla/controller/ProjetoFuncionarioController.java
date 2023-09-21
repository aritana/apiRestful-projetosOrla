package com.example.apiRestfulprojetosOrla.controller;

import com.example.apiRestfulprojetosOrla.dto.ProjetoDto;
import com.example.apiRestfulprojetosOrla.dto.ProjetoFuncionarioDto;
import com.example.apiRestfulprojetosOrla.service.ProjetoFuncionarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projeto-funcionario")
public class ProjetoFuncionarioController {

    private final ProjetoFuncionarioService projetoFuncionarioService;

    @Autowired
    public ProjetoFuncionarioController(ProjetoFuncionarioService projetoFuncionarioService) {
        this.projetoFuncionarioService = projetoFuncionarioService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> vincularFuncionarioProjeto(@RequestBody ProjetoFuncionarioDto projetoFuncionarioDto) {
        Long idProjeto = Long.parseLong(projetoFuncionarioDto.getIdProjeto());
        Long idFuncionario = Long.parseLong(projetoFuncionarioDto.getIdFuncionario());

        boolean foiSalvoComSucesso = projetoFuncionarioService.vincularFuncionarioProjeto(idProjeto, idFuncionario);
        if(foiSalvoComSucesso){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}