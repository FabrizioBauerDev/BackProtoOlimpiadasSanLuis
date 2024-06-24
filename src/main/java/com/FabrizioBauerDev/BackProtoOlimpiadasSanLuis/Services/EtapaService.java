package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Etapa;

import java.util.List;

public interface EtapaService {
    List<Etapa> getAll();

    Etapa getById(int id);

    Etapa createEtapa(Etapa etapa);

    Etapa  updateEtapa(int id, Etapa etapa);

    boolean deleteEtapa(int id);

    long countEtapa();
}
