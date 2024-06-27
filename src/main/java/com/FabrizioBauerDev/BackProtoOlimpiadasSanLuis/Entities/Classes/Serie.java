package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes;


import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums.InstanciaSerie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name ="Series")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InstanciaSerie instancia;

    @Column(nullable = false)
    private LocalTime hora;

    private float viento;

    private int cantidadIntentos;

    @ManyToOne
    @JoinColumn(name = "prueba_id", nullable = false)
    private Prueba prueba;

}
