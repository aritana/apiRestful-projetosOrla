package com.example.apiRestfulprojetosOrla.repository;

import com.example.apiRestfulprojetosOrla.orm.Projeto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends CrudRepository<Projeto, Long> {
}
