package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Prueba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PruebaRepository extends JpaRepository<Prueba,Long> {

    @Query("SELECT p FROM Prueba p WHERE p.etapa.id = :etapaId")
    List<Prueba> findPruebasByEtapaId(@Param("etapaId") Long etapaId);

}
