package com.prueba.tecnica.services;

import com.prueba.tecnica.models.Equipos;
import com.prueba.tecnica.repositories.EquiposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquiposService {

    @Autowired
    EquiposRepository equiposRepository;

    @Transactional(readOnly = true)
    public List<Equipos> obtenerEquipos() {
        return (ArrayList<Equipos>) equiposRepository.findAll();
    }

    @Transactional
    public Equipos guardarEquipo(Equipos equipos) {
        return equiposRepository.save(equipos);
    }

    @Transactional(readOnly = true)
    public Optional<Equipos> obtenerPorId(Long id) {
        return equiposRepository.findById(id);
    }

    @Transactional
    public Equipos actualizarEquipo(Long id, Equipos equipos) {
        equipos.setId(id);
        return equiposRepository.save(equipos);
    }

    @Transactional
    public boolean eliminarEquipo(Long id) {
        try {
            equiposRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
