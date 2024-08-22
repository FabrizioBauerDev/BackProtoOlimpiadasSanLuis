package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.POJO;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParticipacionesExcel {

    private String prueba;
    private String apellido;
    private String nombre;
    private long dni;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate f_nacimiento;

}
