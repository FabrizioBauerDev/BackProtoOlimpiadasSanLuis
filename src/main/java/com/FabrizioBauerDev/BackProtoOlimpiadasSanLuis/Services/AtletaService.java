package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Atleta;


import java.util.List;

public interface AtletaService {
    List<Atleta> getAll();

    Atleta getById(int id);

    Atleta createAtleta(Atleta atleta);

    Atleta  updateAtleta(int id, Atleta atleta);

    boolean deleteAtleta(int id);

    long countAtleta();
}
