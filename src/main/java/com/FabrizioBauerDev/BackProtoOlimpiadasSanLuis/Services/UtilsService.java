package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Services;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Participa;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Serie;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs.ParticipacionDTO;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs.SerieDTO;

import java.util.List;

public interface UtilsService {

    List<SerieDTO> generateSeriesByAnd(long idPrueba);

    List<SerieDTO> generateSeriesByCantAtletas(long idPrueba, int cantidad);

    List<SerieDTO> generateSeriesByCantSeries(long idPrueba, int cantDivison);

}
