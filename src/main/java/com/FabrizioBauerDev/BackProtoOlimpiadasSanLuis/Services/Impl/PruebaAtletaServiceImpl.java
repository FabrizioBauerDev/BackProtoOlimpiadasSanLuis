package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.Impl;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.PruebaAtleta;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.PruebaAtletaRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.PruebaAtletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PruebaAtletaServiceImpl implements PruebaAtletaService {
    @Autowired

    private PruebaAtletaRepository pruebaAtletaRepository;

    private List<PruebaAtleta> getAll(){
        return pruebaAtletaRepository.findAll();
    }

    private PruebaAtleta getById(int id);

    private PruebaAtleta createPruebaAtleta(PruebaAtleta pruebaAtleta);

    private PruebaAtleta  updatePruebaAtleta(int id, PruebaAtleta pruebaAtleta);

    private boolean deletePruebaAtleta(int id);

    private long countPruebaAtleta();
}
