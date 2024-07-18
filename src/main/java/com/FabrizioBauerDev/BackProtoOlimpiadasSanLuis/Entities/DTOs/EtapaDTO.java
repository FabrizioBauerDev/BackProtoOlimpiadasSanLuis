package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtapaDTO {

    private long id;
    private String region;
    private LocalDate fecha;
    private String lugar;
    private short cantAndariveles;

}
