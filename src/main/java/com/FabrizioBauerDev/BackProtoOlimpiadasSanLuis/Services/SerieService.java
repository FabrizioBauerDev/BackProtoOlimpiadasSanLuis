package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Serie;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface SerieService {

    List<Serie> getAll();

    Serie getById(long id);

    Serie createSerie(Serie serie);

    Serie updateSerie(long id, Serie serie);

    boolean deleteSerie(long id);

    long countSeries();

    List<Serie> getSeriesByPruebaId(@RequestParam Long pruebaId);
}
