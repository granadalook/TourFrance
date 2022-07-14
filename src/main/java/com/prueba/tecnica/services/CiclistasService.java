package com.prueba.tecnica.services;

import com.prueba.tecnica.models.Ciclistas;
import com.prueba.tecnica.repositories.CiclistasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CiclistasService {
    @Autowired
    CiclistasRepository ciclistasRepository;

    @Transactional(readOnly = true)
    public List<Ciclistas> getCiclistas() {
        return (List<Ciclistas>) ciclistasRepository.findAll();
    }

    @Transactional
    public Ciclistas saveCiclista(Ciclistas ciclistas) {
        return ciclistasRepository.save(ciclistas);
    }

//    @Transactional(readOnly = true)
//    public List<Ciclistas> findByNombre(String nombre) {
//        return ciclistasRepository.findByName(nombre);
//    }

    @Transactional(readOnly = true)
    public Optional<Ciclistas> findById(String id) {
        return ciclistasRepository.findById(id);
    }

    @Transactional
    public Ciclistas updateCiclista(Long id, Ciclistas ciclistas) {
        ciclistas.setId(id);
        return ciclistasRepository.save(ciclistas);
    }
    @Transactional
    public Boolean deleteUserRol(String id) {
        try {
            ciclistasRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
