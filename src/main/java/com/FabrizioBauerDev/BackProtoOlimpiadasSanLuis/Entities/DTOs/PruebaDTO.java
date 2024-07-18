package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.DTOs;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums.Categorias;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PruebaDTO {

    private long id;
    private Categorias categoria;
    private String tipo;
    private Sexo sexo;
    private String nombre;


}
