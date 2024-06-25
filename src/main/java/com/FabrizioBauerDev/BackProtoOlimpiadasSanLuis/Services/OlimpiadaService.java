package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Olimpiada;

import java.util.List;

public interface OlimpiadaService {

    List<Olimpiada> getAll();

    Olimpiada getById(int id);

    Olimpiada createOlimpiada(Olimpiada olimpiada);

    Olimpiada updateOlimpiada(int id, Olimpiada olimpiada);

    boolean deleteOlimpiada(int id);

    long countOlimpiadas();

}
