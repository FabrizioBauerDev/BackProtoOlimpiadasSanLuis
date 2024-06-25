package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table (name ="Atleta")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private long dni;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;

    @Column(nullable = false)
    private String institucion;
}
