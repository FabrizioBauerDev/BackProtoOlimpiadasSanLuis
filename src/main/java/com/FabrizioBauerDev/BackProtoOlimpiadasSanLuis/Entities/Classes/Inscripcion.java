package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "inscripciones")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Inscripcion {

    @EmbeddedId
    private InscripcionId id;

    @ManyToOne
    @MapsId("atletaId")
    private Atleta atleta;

    @ManyToOne
    @MapsId("pruebaId")
    private Prueba prueba;

}
