package com.prueba.tecnica.repositories;

import com.prueba.tecnica.models.Equipos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EquiposRepository extends CrudRepository<Equipos, Long> {

}
