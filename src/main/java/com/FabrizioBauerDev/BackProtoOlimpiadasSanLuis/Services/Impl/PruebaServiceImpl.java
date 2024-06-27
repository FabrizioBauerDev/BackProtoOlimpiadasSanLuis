package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.Impl;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Olimpiada;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Prueba;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.PruebaRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.PruebaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PruebaServiceImpl implements PruebaService {

    @Autowired
    private PruebaRepository pruebaRepository;

    @Override
    public List<Prueba> getAll() {
        return pruebaRepository.findAll();
    }

    @Override
    public Prueba getById(long id) {
        return pruebaRepository.findById(id).orElse(null);
    }

    @Override
    public Prueba createPrueba(Prueba prueba) {
        return pruebaRepository.save(prueba);
    }

    @Override
    public Prueba updatePrueba(long id, Prueba prueba) {
        Prueba pruebaBBDD = pruebaRepository.findById(id).orElse(null);
        if (pruebaBBDD != null) {
            //Setear todo lo de pruebaBBDD con prueba
            return pruebaRepository.save(pruebaBBDD);
        }
        return null;
    }

    @Override
    @Transactional
    public boolean deletePrueba(long id) {
        try {
            pruebaRepository.deleteById(id);
            return true;
        } catch(EmptyResultDataAccessException e){
            return false;
        }
    }

    @Override
    public long countPruebas() {
        return pruebaRepository.count();
    }
}
