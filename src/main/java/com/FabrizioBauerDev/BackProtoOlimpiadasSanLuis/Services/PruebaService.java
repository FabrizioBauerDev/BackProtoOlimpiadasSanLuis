package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Prueba;

import java.util.List;

public interface PruebaService {

    List<Prueba> getAll();

    Prueba getById(long id);

    Prueba createPrueba(Prueba prueba);

    Prueba updatePrueba(long id, Prueba prueba);

    boolean deletePrueba(long id);

    long countPruebas();


}
