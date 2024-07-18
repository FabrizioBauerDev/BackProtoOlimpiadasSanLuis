package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Etapa;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs.EtapaDTO;

import java.util.List;

public interface EtapaService {
    List<Etapa> getAll();

    List<EtapaDTO> getAllEtapasIdOlimpiada(long id);

    Etapa getById(long id);

    Etapa createEtapa(Etapa etapa);

    Etapa  updateEtapa(long id, Etapa etapa);

    boolean deleteEtapa(long id);

    long countEtapa();
}
