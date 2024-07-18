package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs.EtapaDTO;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Olimpiada;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OlimpiadaEtapa {

    private Olimpiada olimpiada;
    private List<EtapaDTO> etapas;


}
