package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Atleta;


import java.util.List;

public interface AtletaService {
    List<Atleta> getAll();

    Atleta getById(long id);

    Atleta createAtleta(Atleta atleta);

    Atleta  updateAtleta(long id, Atleta atleta);

    boolean deleteAtleta(long id);

    long countAtletas();
}
