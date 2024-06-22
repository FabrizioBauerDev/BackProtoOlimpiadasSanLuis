package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Olimpiada")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Olimpiada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int anio;

    @Column(nullable = false, length = 100)
    private String nombre;
}