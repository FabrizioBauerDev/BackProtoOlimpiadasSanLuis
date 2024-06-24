package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Prueba;

import java.util.List;

public interface PruebaService {

    List<Prueba> getAll();

    Prueba getById(int id);

    Prueba createPrueba(Prueba prueba);

    Prueba updatePrueba(int id, Prueba prueba);

    boolean deletePrueba(int id);

    long countPruebas();


}
