package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.Impl;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Atleta;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.AtletaRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.AtletaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtletaServiceImpl implements AtletaService {

    @Autowired
    private AtletaRepository atletaRepository;

    @Override
    public List<Atleta> getAll() {
        return atletaRepository.findAll();
    }

    @Override
    public Atleta getById(long id) {
        return atletaRepository.findById(id).orElse(null);
    }

    @Override
    public Atleta createAtleta(Atleta atleta) {
        return atletaRepository.save(atleta);
    }

    @Override
    @Transactional
    public Atleta updateAtleta(long id, Atleta atleta) {
        Atleta atleta1 = atletaRepository.findById(id).orElse(null);
        if (atleta1 != null) {
            // Setear cada campo de atleta1 con etapa
            return atletaRepository.save(atleta1);
        }return null;
    }

    @Override
    @Transactional
    public boolean deleteAtleta(long id) {
        try {
            atletaRepository.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }
    }

    @Override
    public long countAtletas() {
        return atletaRepository.count();
    }
}
