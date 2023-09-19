package com.example.apiRestfulprojetosOrla.repository;

import com.example.apiRestfulprojetosOrla.orm.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends CrudRepository<Email, Long> {
}
