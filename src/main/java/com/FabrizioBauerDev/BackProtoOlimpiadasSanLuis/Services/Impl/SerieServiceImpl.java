package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.Impl;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Serie;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.SerieRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.SerieService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class SerieServiceImpl implements SerieService {

    @Autowired
    private SerieRepository serieRepository;

    @Override
    public List<Serie> getAll() {
        return serieRepository.findAll();
    }

    @Override
    public Serie getById(long id) {
        return serieRepository.findById(id).orElse(null);
    }

    @Override
    public Serie createSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    @Override
    public Serie updateSerie(long id, Serie serie) {
        Serie serie1 = serieRepository.findById(id).orElse(null);
        if (serie1 != null) {
            serie1.setHora(serie.getHora());
            serie1.setViento(serie.getViento());
            serie1.setCantidadIntentos(serie.getCantidadIntentos());
            return serieRepository.save(serie);
        }
        return null;
    }

    @Override
    @Transactional
    public boolean deleteSerie(long id) {
        try{
            serieRepository.deleteById(id);
            return true;
        }catch(EmptyResultDataAccessException e){
            return false;
        }
    }

    @Override
    public long countSeries() {
        return serieRepository.count();
    }

    @Override
    public List<Serie> getSeriesByPruebaId(@RequestParam Long pruebaId) {
        return serieRepository.findAllByPruebaId(pruebaId);
    }
}
