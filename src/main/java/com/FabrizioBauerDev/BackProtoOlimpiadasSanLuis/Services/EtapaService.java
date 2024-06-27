package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Etapa;

import java.util.List;

public interface EtapaService {
    List<Etapa> getAll();

    Etapa getById(long id);

    Etapa createEtapa(Etapa etapa);

    Etapa  updateEtapa(long id, Etapa etapa);

    boolean deleteEtapa(long id);

    long countEtapa();
}
