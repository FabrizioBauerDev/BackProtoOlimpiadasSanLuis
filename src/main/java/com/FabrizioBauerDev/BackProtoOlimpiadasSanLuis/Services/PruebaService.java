package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Prueba;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs.PruebaDTO;

import java.util.List;

public interface PruebaService {

    List<Prueba> getAll();

    List<PruebaDTO> getAllPruebasIdEtapa(long id);

    Prueba getById(long id);

    Prueba createPrueba(Prueba prueba);

    Prueba updatePrueba(long id, Prueba prueba);

    boolean deletePrueba(long id);

    long countPruebas();


}
