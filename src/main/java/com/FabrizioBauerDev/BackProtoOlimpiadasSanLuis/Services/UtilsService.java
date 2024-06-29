package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Serie;

import java.util.List;

public interface UtilsService {

    List<Serie> generateSeriesByAnd(long idPrueba);

    List<Serie> generateSeriesByAtleta(long idPrueba, int cantAtletas);

    List<Serie> generateSeriesByDivision(long idPrueba, int cantDivison);

}
