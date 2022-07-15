package com.prueba.tecnica.services;


import com.prueba.tecnica.models.Pais;
import com.prueba.tecnica.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaisService {

    @Autowired
    PaisRepository paisRepository;

    @Transactional(readOnly = true)
    public List<Pais> obtenerPaises() {
        return (ArrayList<Pais>) paisRepository.findAll();
    }

    @Transactional
    public Pais guardarPais(Pais pais) {
        return paisRepository.save(pais);
    }

    @Transactional(readOnly = true)
    public Optional<Pais> obtenerPorId(Long id) {
        return paisRepository.findById(id);
    }

    @Transactional
    public Pais actualizarPais(Long id, Pais pais) {
        pais.setId(id);
        return paisRepository.save(pais);
    }

    @Transactional
    public boolean eliminarPais(Long id) {
        try {
            paisRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
