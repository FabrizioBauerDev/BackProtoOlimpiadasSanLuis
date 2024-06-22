package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums.Categorias;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Enums.TipoPrueba;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="Prueba")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prueba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categorias categoria;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPrueba tipo;

    @Column(nullable = false, length = 100)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "etapa_id", nullable = false)
    private Etapa etapa;
}
