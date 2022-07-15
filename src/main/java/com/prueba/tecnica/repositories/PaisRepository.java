package com.prueba.tecnica.repositories;

import com.prueba.tecnica.models.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends CrudRepository<Pais,Long> {
}
