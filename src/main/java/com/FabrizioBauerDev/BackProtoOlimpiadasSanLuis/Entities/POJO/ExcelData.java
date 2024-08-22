package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.POJO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelData {

    private String categoria;
    private String sexo;
    private List<ParticipacionesExcel> atletas;

}
