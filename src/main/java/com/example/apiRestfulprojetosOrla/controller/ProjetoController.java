package com.example.apiRestfulprojetosOrla.controller;

import com.example.apiRestfulprojetosOrla.dto.FuncionarioDto;
import com.example.apiRestfulprojetosOrla.dto.ProjetoDto;
import com.example.apiRestfulprojetosOrla.model.ProjetoModel;
import com.example.apiRestfulprojetosOrla.orm.Projeto;
import com.example.apiRestfulprojetosOrla.service.ProjetoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/projeto")
public class ProjetoController {

    private final ProjetoService projetoService;

    @Autowired
    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProjetoDto> criarProjeto(@RequestBody @Valid ProjetoDto projetoDto) {
        ProjetoModel projetoModel = ProjetoModel.builder()
                .nome(projetoDto.getNome())
                .build();

        ProjetoDto ProjetoDto = projetoService.criarProjeto(projetoModel);
        return new ResponseEntity(ProjetoDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDto> encontrarProjetoPorId(@PathVariable Long id) {
        ProjetoDto projeto = projetoService.encontrarProjetoPorId(id);
        return new ResponseEntity(projeto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProjetoDto>> listarTodosProjetos() {
        List<ProjetoDto> projetosDto = projetoService.listarTodosProjetos();
        return new ResponseEntity<>(projetosDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable Long id) {
        boolean foiDeletadoComSucesso = projetoService.deletarProjeto(id);
        if(foiDeletadoComSucesso){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private ProjetoDto toDto(Projeto projetoPersistido) {
        ProjetoDto projetoDto = new ProjetoDto();
        projetoDto.setId(Long.toString(projetoPersistido.getId()));
        projetoDto.setNome(projetoPersistido.getNome());
        projetoDto.setData_criacao(projetoPersistido.getData_criacao().toString());
        return  projetoDto;
    }
}
