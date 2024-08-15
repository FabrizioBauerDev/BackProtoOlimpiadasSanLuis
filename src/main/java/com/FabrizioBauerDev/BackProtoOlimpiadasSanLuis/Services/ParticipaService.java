package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.*;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs.ParticipacionDTO;

import java.util.List;

public interface ParticipaService {
    List<Participa> getAll();

    Participa getById(ParticipaId id);

    List<ParticipacionDTO> getAllBySerie(long serieId);

    List<ParticipacionDTO> getAllByPrueba(long pruebaId);

    List<Serie> getAllByAtleta(long atletaId);

    Participa createParticipa(Participa participa);

    Participa updateParticipa(ParticipaId id, ParticipacionDTO participa);

    boolean deleteParticipante(ParticipaId id);

    long countParticipantes();

    List<Participa> multipleUpdateParticipa(long serieId, List<ParticipacionDTO> participacionDTO);
}
