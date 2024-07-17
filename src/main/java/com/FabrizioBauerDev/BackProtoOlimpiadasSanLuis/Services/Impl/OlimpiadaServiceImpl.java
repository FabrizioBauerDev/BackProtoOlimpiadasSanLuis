package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.Impl;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Etapa;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Olimpiada;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.OlimpiadaRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.OlimpiadaService;
import jakarta.transaction.Transactional;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class OlimpiadaServiceImpl implements OlimpiadaService {

    @Autowired
    private OlimpiadaRepository olimpiadaRepository;


    @Override
    public List<Olimpiada> getAll() {
        return olimpiadaRepository.findAll();
    }

    @Override
    public Olimpiada getById(long id) {
        return olimpiadaRepository.findById(id).orElse(null);
    }

    @Override
    public Olimpiada createOlimpiada(Olimpiada olimpiada) {
        return olimpiadaRepository.save(olimpiada);
    }

    @Override
    public Olimpiada updateOlimpiada(long id, Olimpiada olimpiada) {
        Olimpiada olimpiadaBBDD = olimpiadaRepository.findById(id).orElse(null);
        if (olimpiadaBBDD != null) {
            //Setear todo lo de olimpiadaBBDD
            return olimpiadaRepository.save(olimpiadaBBDD);
        }
        return null;
    }

    @Override
    @Transactional
    public boolean deleteOlimpiada(long id) {
        try {
            olimpiadaRepository.deleteById(id);
            return true;
        } catch(EmptyResultDataAccessException e){
            return false;
        }
    }

    @Override
    public long countOlimpiadas() {
        return olimpiadaRepository.count();
    }
}
