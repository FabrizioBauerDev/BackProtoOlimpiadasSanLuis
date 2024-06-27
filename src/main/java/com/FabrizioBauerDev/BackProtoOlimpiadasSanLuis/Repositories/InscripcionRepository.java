package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories;


import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Inscripcion;
import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.InscripcionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, InscripcionId> {

    @Query("SELECT i FROM Inscripcion i WHERE i.prueba.id = :pruebaId")
    List<Inscripcion> findByPruebaId(@Param("pruebaId") Long pruebaId);

    @Query("SELECT i FROM Inscripcion i WHERE i.atleta.id = :atletaId")
    List<Inscripcion> findByAtletaId(@Param("atletaId") Long atletaId);
}
