package com.example.apiRestfulprojetosOrla.service;

import com.example.apiRestfulprojetosOrla.dto.FuncionarioDto;
import com.example.apiRestfulprojetosOrla.dto.ProjetoDto;
import com.example.apiRestfulprojetosOrla.model.ProjetoModel;
import com.example.apiRestfulprojetosOrla.orm.Funcionario;
import com.example.apiRestfulprojetosOrla.orm.Projeto;
import com.example.apiRestfulprojetosOrla.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public ProjetoDto criarProjeto(ProjetoModel projetoModel) {
       Projeto projeto = new Projeto();
       projeto.setNome(projetoModel.getNome());
       projeto.setData_criacao(LocalDate.now());

       Projeto projetoPersistido = repository.save(projeto);
       ProjetoDto projetoDto = toDto(projetoPersistido);

       return projetoDto;
    }

    public ProjetoDto encontrarProjetoPorId(Long id){
        Projeto projeto =  repository.findById(id).orElseThrow(()-> new NoSuchElementException("Projeto não encontrado"));
        ProjetoDto projetoDto = toDto(projeto);
        return  projetoDto;
    }
    public List<ProjetoDto> listarTodosProjetos(){
        Iterable<Projeto> projetosIterable = repository.findAll();
        List<ProjetoDto> projetos = new ArrayList<>();

        for (Projeto projeto : projetosIterable) {
            projetos.add(toDto(projeto));
        }
        return projetos;
    }
    public boolean deletarProjeto(Long id){
        ProjetoDto projetoDto = encontrarProjetoPorId(id);
        if(projetoDto != null){
            repository.deleteById(id);
            return true;
        }
        return  false;
    }

    private ProjetoDto toDto(Projeto projetoPersistido) {
        ProjetoDto projetoDto = new ProjetoDto();
        projetoDto.setId(Long.toString(projetoPersistido.getId()));
        projetoDto.setNome(projetoPersistido.getNome());
        projetoDto.setData_criacao(projetoPersistido.getData_criacao().toString());
        return  projetoDto;
    }

}