package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.Impl;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Atleta;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Inscripcion;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.InscripcionId;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Prueba;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.InscripcionRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.InscripcionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscripcionServiceImpl implements InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Override
    public List<Inscripcion> getAll() {
        return inscripcionRepository.findAll();
    }

    @Override
    public Inscripcion getById(InscripcionId id) {
        return inscripcionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Atleta> getAllByPrueba(long  pruebaId) {
        List<Inscripcion> inscripciones = inscripcionRepository.findByPruebaId(pruebaId);
        return inscripciones.stream()
                .map(Inscripcion::getAtleta)
                .collect(Collectors.toList());
    }

    @Override
    public List<Prueba> getAllByAtleta(long atletaId) {
        List<Inscripcion> inscripciones = inscripcionRepository.findByAtletaId(atletaId);
        return inscripciones.stream()
                .map(Inscripcion::getPrueba)
                .collect(Collectors.toList());
    }

    @Override
    public Inscripcion createInscripcion(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    @Override
    public Inscripcion updateInscripcion(InscripcionId id, Inscripcion inscripcion) {
        Inscripcion inscripcionAux = inscripcionRepository.findById(id).orElse(null);
        if (inscripcionAux != null) {
            return inscripcionRepository.save(inscripcionAux);
        }
        return null;
    }

    @Override
    @Transactional
    public boolean deleteInscripcion(InscripcionId id) {
        try {
            inscripcionRepository.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }
    }

    @Override
    public long countInscripciones() {
        return inscripcionRepository.count();
    }
}
