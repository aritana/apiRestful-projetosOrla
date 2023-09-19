package com.example.apiRestfulprojetosOrla.repository;

import com.example.apiRestfulprojetosOrla.orm.CPF;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CPFRepository extends CrudRepository<CPF, Long> {
}
