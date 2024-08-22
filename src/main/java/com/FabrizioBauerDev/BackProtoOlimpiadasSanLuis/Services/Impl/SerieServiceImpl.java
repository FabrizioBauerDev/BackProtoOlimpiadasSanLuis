package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.Impl;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Prueba;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Serie;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs.SerieDTO;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums.InstanciaSerie;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.PruebaRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories.SerieRepository;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services.SerieService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieServiceImpl implements SerieService {

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private PruebaRepository pruebaRepository;

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
    @Transactional
    public List<SerieDTO> createNSeries(Long pruebaId, int cant) {
        // Obtener la prueba
        Prueba prueba = pruebaRepository.findById(pruebaId).orElse(null);

        // Crear las series en la base de datos
        List<Serie> series = new ArrayList<>();
        for (int i = 0; i < cant; i++) {
            series.add(new Serie("Final " + (char) ('A' + i), InstanciaSerie.Final, prueba));
        }
        series = serieRepository.saveAll(series);

        //Pasar de series a seriesDTO
        return series.stream().map(serie -> {
            SerieDTO serieDTO = new SerieDTO();
            serieDTO.setNombre(serie.getNombre());
            serieDTO.setInstancia(serie.getInstancia());
            serieDTO.setPruebaId(serie.getPrueba().getId());
            return serieDTO;
        }).collect(Collectors.toList());
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
