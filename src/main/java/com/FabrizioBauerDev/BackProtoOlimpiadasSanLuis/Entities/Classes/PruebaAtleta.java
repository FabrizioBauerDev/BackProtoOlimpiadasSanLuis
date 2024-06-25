package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prueba_atleta", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"atleta_id", "prueba_id"})
})
public class PruebaAtleta implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "atleta_id", nullable = false)
    private Atleta atleta;

    @Id
    @ManyToOne
    @JoinColumn(name = "prueba_id", nullable = false)
    private Prueba prueba;

    // HashCode y Equals para la clave compuesta
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PruebaAtleta that = (PruebaAtleta) o;
        return atleta.equals(that.atleta) && prueba.equals(that.prueba);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atleta, prueba);
    }
}


