package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums.Regiones;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="Institucion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Institucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Regiones region;

    @Column(nullable = false)
    private long puntuacion;

    public Institucion(String nombre, Regiones region, long puntuacion) {
        this.nombre = nombre;
        this.region = region;
        this.puntuacion = puntuacion;
    }
}
