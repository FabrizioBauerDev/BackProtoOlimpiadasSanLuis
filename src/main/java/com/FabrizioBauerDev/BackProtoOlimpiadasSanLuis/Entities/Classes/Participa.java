package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums.CondicionParticipa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "participaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Participa {

    @EmbeddedId
    private ParticipaId id;

    private CondicionParticipa condicion;

    @Column(length = 4)
    private String viento;

    private String marca;

    private int puesto;

    private int andarivel;

    @ManyToOne
    @MapsId("atletaId")
    private Atleta atleta;

    @ManyToOne
    @MapsId("serieId")
    private Serie serie;

    public Participa(ParticipaId id,Atleta atleta,Serie serie) {
        this.id = id;
        this.atleta = atleta;
        this.serie = serie;
    }
    
}
