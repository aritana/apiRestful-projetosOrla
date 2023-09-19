package com.example.apiRestfulprojetosOrla.repository;

import com.example.apiRestfulprojetosOrla.orm.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
}
