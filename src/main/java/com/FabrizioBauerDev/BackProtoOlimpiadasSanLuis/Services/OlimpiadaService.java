package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Etapa;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Olimpiada;

import java.util.List;

public interface OlimpiadaService {

    List<Olimpiada> getAll();



    Olimpiada getById(long id);

    Olimpiada createOlimpiada(Olimpiada olimpiada);

    Olimpiada updateOlimpiada(long id, Olimpiada olimpiada);

    boolean deleteOlimpiada(long id);

    long countOlimpiadas();

}
