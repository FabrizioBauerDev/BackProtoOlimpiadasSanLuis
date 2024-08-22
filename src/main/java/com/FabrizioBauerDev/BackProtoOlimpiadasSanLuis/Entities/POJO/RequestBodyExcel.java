package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestBodyExcel {

    private List<ExcelData> excelData;
    private String region;
    private String institucion;


}
