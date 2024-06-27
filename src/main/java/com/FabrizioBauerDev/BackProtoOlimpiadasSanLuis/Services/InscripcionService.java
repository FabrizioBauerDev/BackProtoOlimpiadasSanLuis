package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Atleta;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Inscripcion;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.InscripcionId;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Prueba;

import java.util.List;

public interface InscripcionService {

    List<Inscripcion> getAll();

    Inscripcion getById(InscripcionId id);

    List<Atleta> getAllByPrueba(long pruebaId);

    List<Prueba> getAllByAtleta(long atletaId);

    Inscripcion createInscripcion(Inscripcion inscripcion);

    Inscripcion updateInscripcion(InscripcionId id, Inscripcion inscripcion);

    boolean deleteInscripcion(InscripcionId id);

    long countInscripciones();

}
