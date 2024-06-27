package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class InscripcionId {

    private long atletaId;
    private long pruebaId;

}
