package com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Repositories;

import com.FabrizioBauerDev.BackProtoOlimpiadasSanLuis.Entities.Classes.Etapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtapaRepository extends JpaRepository<Etapa, Long> {

    @Query("SELECT e FROM Etapa e WHERE e.olimpiada.id = :olimpiadaId")
    List<Etapa> findEtapasByOlimpiadaId(@Param("olimpiadaId") Long olimpiadaId);

}
