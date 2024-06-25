package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.PruebaAtleta;

import java.util.List;

public interface PruebaAtletaService {

    List<PruebaAtleta> getAll();

    PruebaAtleta getById(int id);

    PruebaAtleta createPruebaAtleta(PruebaAtleta pruebaAtleta);

    PruebaAtleta  updatePruebaAtleta(int id, PruebaAtleta pruebaAtleta);

    boolean deletePruebaAtleta(int id);

    long countPruebaAtleta();

}
