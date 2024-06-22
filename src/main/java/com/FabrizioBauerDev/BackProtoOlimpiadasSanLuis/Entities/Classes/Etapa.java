package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums.Regiones;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Etapa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etapa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Regiones region;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;

    @Column(nullable = false, length = 100)
    private String lugar;

    @Column
    private short cant_andariveles;

    @ManyToOne
    @JoinColumn(name = "olimpiada_id", nullable = false)
    private Olimpiada olimpiada;

}
