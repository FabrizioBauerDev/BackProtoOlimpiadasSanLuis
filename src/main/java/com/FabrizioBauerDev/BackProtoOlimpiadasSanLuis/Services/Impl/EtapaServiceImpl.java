package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.Impl;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Etapa;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs.EtapaDTO;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.EtapaRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.EtapaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EtapaServiceImpl implements EtapaService {

    @Autowired
    private EtapaRepository etapaRepository;

    @Override
    public List<Etapa> getAll() {
        return etapaRepository.findAll();
    }

    @Override
    public List<EtapaDTO> getAllEtapasIdOlimpiada(long id) {
        List<Etapa> etapas = etapaRepository.findEtapasByOlimpiadaId(id);

        return etapas.stream().map(etapa -> {
            EtapaDTO etapaDTO = new EtapaDTO();
            etapaDTO.setId(etapa.getId());
            etapaDTO.setRegion(etapa.getRegion().toString());
            etapaDTO.setFecha(etapa.getFecha());
            etapaDTO.setLugar(etapa.getLugar());
            etapaDTO.setCantAndariveles(etapa.getCantAndariveles());
            return etapaDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public Etapa getById(long id) {
        return etapaRepository.findById(id).orElse(null);
    }

    @Override
    public Etapa createEtapa(Etapa etapa) {
        return etapaRepository.save(etapa);
    }

    @Override
    @Transactional
    public Etapa updateEtapa(long id, Etapa etapa) {
        Etapa etapa1 = etapaRepository.findById(id).orElse(null);
        if (etapa1 != null) {
            // Setear cada campo de etapa1 con etapa
            return etapaRepository.save(etapa1);
        }return null;
    }

    @Override
    @Transactional
    public boolean deleteEtapa(long id) {
        try {
            etapaRepository.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }
    }

    @Override
    public long countEtapa() {
        return etapaRepository.count();
    }
}
