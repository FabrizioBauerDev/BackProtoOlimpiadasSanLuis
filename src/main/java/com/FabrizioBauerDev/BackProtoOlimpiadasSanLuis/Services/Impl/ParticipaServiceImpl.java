package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.Impl;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.*;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.ParticipaRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.ParticipaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipaServiceImpl implements ParticipaService {

    @Autowired
    private ParticipaRepository participaRepository;

    @Override
    public List<Participa> getAll() {
        return participaRepository.findAll();
    }

    @Override
    public Participa getById(ParticipaId id) {
        return participaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Atleta> getAllBySerie(long serieId) {
        List<Participa> participaciones = participaRepository.findBySerieId(serieId);
        return participaciones.stream()
                .map(Participa::getAtleta)
                .collect(Collectors.toList());
    }

    @Override
    public List<Serie> getAllByAtleta(long atletaId) {
        List<Participa> participaciones = participaRepository.findByAtletaId(atletaId);
        return participaciones.stream()
                .map(Participa::getSerie)
                .collect(Collectors.toList());
    }

    @Override
    public Participa createParticipa(Participa participa) {
        return participaRepository.save(participa);
    }

    @Override
    public Participa updateParticipa(ParticipaId id, Participa participa) {
        Participa participa1 = participaRepository.findById(id).orElse(null);
        if (participa1 == null) {
            // Setear todo
            return participaRepository.save(participa1);
        }
        return null;
    }

    @Override
    @Transactional
    public boolean deleteParticipante(ParticipaId id) {
        try {
            participaRepository.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }
    }

    @Override
    public long countParticipantes() {
        return participaRepository.count();
    }
}
