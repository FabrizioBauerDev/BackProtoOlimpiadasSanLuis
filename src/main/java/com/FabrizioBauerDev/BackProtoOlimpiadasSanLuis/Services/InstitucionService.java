package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services;


import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Institucion;

import java.util.List;

public interface InstitucionService {

    List<Institucion> getAll();

    Institucion getById(long id);

    Institucion createInstitucion(Institucion institucion);

    Institucion  updateInstitucion(long id, Institucion institucion);

    boolean deleteInstitucion(long id);

    long countInstituciones();

}
