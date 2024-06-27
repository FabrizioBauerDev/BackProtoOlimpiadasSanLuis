package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.*;

import java.util.List;

public interface ParticipaService {
    List<Participa> getAll();

    Participa getById(ParticipaId id);

    List<Atleta> getAllBySerie(long serieId);

    List<Serie> getAllByAtleta(long atletaId);

    Participa createParticipa(Participa participa);

    Participa updateParticipa(ParticipaId id, Participa participa);

    boolean deleteParticipante(ParticipaId id);

    long countParticipantes();
}
