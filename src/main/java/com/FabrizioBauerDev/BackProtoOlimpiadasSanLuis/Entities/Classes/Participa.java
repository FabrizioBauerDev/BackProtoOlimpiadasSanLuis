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

    //Puede que hayan 0 elementos, 1 elemento (prueba pista) o cantIntentos
    @ElementCollection
    private List<String> vientos;

    //Puede ser 0 si condicion no OK, 1 prueba de pista o cantIntentos
    @ElementCollection
    private List<String> marcas;

    private int posicion;

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
