    package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Atleta;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.ParticipaId;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums.CondicionParticipa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipacionDTO {

    private ParticipaId id;
    private CondicionParticipa condicion;
    private String viento;
    private String marca;
    private int puesto;
    private int andarivel;
    private Atleta atleta;
    private String nombreSerie;

}
