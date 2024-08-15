package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums.InstanciaSerie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerieDTO {

    private long id;
    private String nombre;
    private InstanciaSerie instancia;
    private LocalTime hora;
    private float viento;
    private int cantidadIntentos;
    private long pruebaId;

}
