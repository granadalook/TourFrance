package com.prueba.tecnica.repositories;

import com.prueba.tecnica.models.Ciclistas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiclistasRepository extends CrudRepository<Ciclistas, String> {
   // public abstract List<Ciclistas> findByName(String nombre);
}
